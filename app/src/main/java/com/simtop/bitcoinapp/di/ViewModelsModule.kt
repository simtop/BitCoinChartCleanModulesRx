package com.simtop.bitcoinapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.simtop.bitcoinapp.presentation.chart.ChartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ChartViewModel::class)
    abstract fun bindChartViewModel(viewModel: ChartViewModel): ViewModel

}
