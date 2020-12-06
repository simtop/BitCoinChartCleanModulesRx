package com.simtop.domain.core

import io.reactivex.Single

abstract class BaseUseCase<T, PARAMS> protected constructor() {

    protected abstract fun buildUseCase(params: PARAMS): Single<T>

    fun execute(params: PARAMS) = buildUseCase(params)
}