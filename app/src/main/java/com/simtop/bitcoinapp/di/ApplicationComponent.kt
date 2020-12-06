package com.simtop.bitcoinapp.di

import com.simtop.bitcoinapp.BitCoinAppApplication
import com.simtop.bitcoinapp.presentation.chart.ChartFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        UrlModule::class,
        BitCoinApiModule::class,
        MarketPriceRepositoryModule::class,
        ViewModelsModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: BitCoinAppApplication): ApplicationComponent
    }

    fun inject(chartFragment: ChartFragment)
}
