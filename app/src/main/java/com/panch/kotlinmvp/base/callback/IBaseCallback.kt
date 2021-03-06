package com.panch.kotlinmvp.base.callback

/**
 * Created by Panch on 1.10.2017.
 */
interface IBaseCallback<in T> {
    fun onSuccess(data: T)
    fun onFail(errorMessage: String?)
}