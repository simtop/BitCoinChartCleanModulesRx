package com.simtop.bitcoinapp.presentation.chart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simtop.domain.models.marketprice.MarketPriceModel
import com.simtop.domain.usecases.GetMarketPriceUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChartViewModel @Inject constructor(
    private val getMarketPriceUseCase: GetMarketPriceUseCase,
) : ViewModel() {

    private val _chartViewState =
        MutableLiveData<ChartViewState<MarketPriceModel>>()
    val chartViewState: LiveData<ChartViewState<MarketPriceModel>>
        get() = _chartViewState

    private val compositeDisposable = CompositeDisposable()

    init {
        compositeDisposable.add(getMarketPrice())
    }

    fun getMarketPrice(): Disposable {
        _chartViewState.postValue(ChartViewState.Loading)
        return getMarketPriceUseCase.execute(getMarketPriceUseCase.Params())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { _chartViewState.postValue(ChartViewState.Success(it)) },
                { _chartViewState.postValue(ChartViewState.Error(it.message ?: "Default Error")) }
            )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}

sealed class ChartViewState<out T> {
    data class Success<out T>(val result: T) : ChartViewState<T>()
    data class Error(val result: String) : ChartViewState<Nothing>()
    object Loading : ChartViewState<Nothing>()
}