package com.panch.kotlinmvp.base.model

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Panch on 1.10.2017.
 */
abstract class BaseModel : IBaseModel {

    protected val compositeDisposable = CompositeDisposable()


    override fun onDispose() {
        compositeDisposable.dispose()
    }
}