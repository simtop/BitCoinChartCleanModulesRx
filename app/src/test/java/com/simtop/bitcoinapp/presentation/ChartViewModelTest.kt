package com.simtop.bitcoinapp.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.simtop.bitcoinapp.getValueForTest
import com.simtop.bitcoinapp.presentation.chart.ChartViewState
import com.simtop.bitcoinapp.presentation.chart.ChartViewModel
import com.simtop.domain.usecases.GetMarketPriceUseCase
import com.simtop.testutils.fakeMarketPriceModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.reactivex.Single
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

internal class ChartViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val getMarketPriceUseCase: GetMarketPriceUseCase = mockk()

    private val chartViewModel: ChartViewModel by lazy {
        ChartViewModel(getMarketPriceUseCase)
    }

    @Test
    fun `when we get market model it succeeds and shows loader`() {

        coEvery { getMarketPriceUseCase.execute(any()) } returns Single.just(
            fakeMarketPriceModel
        )

        chartViewModel.getMarketPrice()

        chartViewModel.chartViewState.getValueForTest() shouldBeEqualTo ChartViewState.Loading

        Thread.sleep(1000)

        coVerify(exactly = 1) {
            getMarketPriceUseCase.execute(any())
        }

        val response = chartViewModel.chartViewState.getValueForTest()

        if (response is ChartViewState.Success) {
            response.result shouldBeEqualTo fakeMarketPriceModel
        }
    }

    @Test
    fun `when we get market price model it fails and shows error`() {

        coEvery { getMarketPriceUseCase.execute(any()) } returns Single.error(
            Exception("Error getting list of categories")
        )

        chartViewModel.getMarketPrice()

        chartViewModel.chartViewState.getValueForTest() shouldBeEqualTo ChartViewState.Loading

        Thread.sleep(1000)

        coVerify(exactly = 1) {
            getMarketPriceUseCase.execute(any())
        }

        val response = chartViewModel.chartViewState.getValueForTest()

        if (response is ChartViewState.Error) {
            response.result.message shouldBeEqualTo "Error getting list of categories"
        }
    }
}
