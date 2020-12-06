package com.simtop.domain.usecases

import com.simtop.domain.core.BaseUseCase
import com.simtop.domain.models.marketprice.MarketPriceModel
import com.simtop.domain.repository.MarketPriceRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetMarketPriceUseCase @Inject constructor(
    private val marketPriceRepository: MarketPriceRepository
) : BaseUseCase<MarketPriceModel, GetMarketPriceUseCase.Params>() {

    inner class Params()

    override fun buildUseCase(params: Params): Single<MarketPriceModel> {
        return marketPriceRepository.getMarketPrice()
    }
}