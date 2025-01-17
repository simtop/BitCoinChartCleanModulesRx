package com.simtop.testutils

import com.simtop.domain.models.marketprice.AxisModel
import com.simtop.domain.models.marketprice.MarketPriceModel

val fakeMarketPriceModel = MarketPriceModel(
    "Average USD market price across major bitcoin exchanges.",
    "Market Price (USD)",
    "day",
    "ok",
    "USD",
    listOf(
        AxisModel(1605225600, 16295.57f),
        AxisModel(1605312000, 16339.33f)
    )
)