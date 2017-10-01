package com.panch.kotlinmvp.pages.activityBased.bands.view

import com.panch.kotlinmvp.base.view.IBaseView
import com.panch.kotlinmvp.pages.activityBased.bands.model.Band

/**
 * Created by Panch on 1.10.2017.
 */
interface IBandsView : IBaseView {

    fun onLoadSuccess(data: List<Band>)
    fun onLoadFail(errorMessage: String?)

}