package com.simtop.bitcoinapp.di

import com.simtop.bitcoinapp.test.ChartTest
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        TestUrlModule::class,
        BitCoinApiModule::class,
        MarketPriceRepositoryModule::class,
        ViewModelsModule::class
    ]
)
interface TestApplicationComponent : ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: TestApplication): TestApplicationComponent
    }

    fun inject(chartTest: ChartTest)
}