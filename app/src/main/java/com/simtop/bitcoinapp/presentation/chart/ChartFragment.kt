package com.simtop.bitcoinapp.presentation.chart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.simtop.bitcoinapp.R
import com.simtop.bitcoinapp.appComponent
import com.simtop.bitcoinapp.core.gone
import com.simtop.bitcoinapp.core.observe
import com.simtop.bitcoinapp.core.showToast
import com.simtop.bitcoinapp.core.visible
import com.simtop.bitcoinapp.databinding.FragmentChartFragmentBinding
import com.simtop.bitcoinapp.presentation.MainActivity
import com.simtop.domain.models.marketprice.MarketPriceModel
import javax.inject.Inject

class ChartFragment : Fragment(R.layout.fragment_chart_fragment) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val chartViewModel by viewModels<ChartViewModel> {
        viewModelFactory
    }

    private lateinit var fragmentChartFragmentBinding: FragmentChartFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appComponent.inject(this)

        val binding = FragmentChartFragmentBinding.bind(view)
        fragmentChartFragmentBinding = binding

        (requireActivity() as MainActivity).showToolbar(false)

        setUpRetryListener()

        chartViewModel.getMarketPrice()

        observe(
            chartViewModel.chartViewState,
            { viewState ->
                viewState?.let { renderChartViewState(it) }
            }
        )
    }

    private fun setUpRetryListener() {
        fragmentChartFragmentBinding.retry.setOnClickListener {
            chartViewModel.getMarketPrice()
        }
    }

    private fun renderChartViewState(it: ChartViewState<MarketPriceModel>) {
        when (it) {
            is ChartViewState.Success -> {
                fragmentChartFragmentBinding.chartView.visible()
                fragmentChartFragmentBinding.progressBar.gone()
                fragmentChartFragmentBinding.errorState.gone()
                fragmentChartFragmentBinding.chartView.bind(it.result)

            }
            is ChartViewState.Error -> {
                fragmentChartFragmentBinding.chartView.gone()
                fragmentChartFragmentBinding.progressBar.gone()
                fragmentChartFragmentBinding.errorState.visible()
                requireActivity().showToast(it.result)
            }
            ChartViewState.Loading -> {
                fragmentChartFragmentBinding.chartView.gone()
                fragmentChartFragmentBinding.progressBar.visible()
            }
        }
    }
}