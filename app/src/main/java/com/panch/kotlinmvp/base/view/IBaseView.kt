package com.panch.kotlinmvp.base.view

/**
 * Created by Panch on 1.10.2017.
 */
interface IBaseView {
    fun showSnackbar(message: String)
    fun showLoading()
    fun hideLoading()
    fun showError()
    fun hideError()
}