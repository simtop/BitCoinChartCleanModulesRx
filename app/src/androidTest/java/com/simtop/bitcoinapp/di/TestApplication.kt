package com.simtop.bitcoinapp.di

import com.simtop.bitcoinapp.BitCoinAppApplication

class TestApplication : BitCoinAppApplication() {

    override fun buildApiComponent() {
        appComponent = DaggerTestApplicationComponent.factory()
            .create(this)
    }
}