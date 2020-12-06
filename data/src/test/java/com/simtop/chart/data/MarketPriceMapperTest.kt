package com.simtop.chart.data

import com.simtop.chart.data.mappers.MarketPriceMapper
import com.simtop.testutils.fakeMarketPriceModel
import com.simtop.testutils.fakeMarketPriceResponse
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class MarketPriceMapperTest {

    @Test
    fun `when we pass a market price response we have to map it to market price model`() {
        val input = fakeMarketPriceResponse

        val output = MarketPriceMapper.fromMarketPriceResponseToMarketPriceModel(input)

        val expectedResult = fakeMarketPriceModel
        output shouldBeEqualTo expectedResult
    }
}