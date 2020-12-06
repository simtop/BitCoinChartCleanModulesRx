package com.simtop.bitcoinapp.di


import com.simtop.chart.data.repository.MarketPriceRepositoryImpl
import com.simtop.domain.repository.MarketPriceRepository
import dagger.Binds
import dagger.Module

@Module
abstract class MarketPriceRepositoryModule {
    @Binds
    abstract fun getMarketPriceRepository(repository: MarketPriceRepositoryImpl): MarketPriceRepository
}
