package com.simtop.domain.repository

import com.simtop.domain.models.marketprice.MarketPriceModel
import io.reactivex.Single

interface MarketPriceRepository {

    fun getMarketPrice(): Single<MarketPriceModel>
}