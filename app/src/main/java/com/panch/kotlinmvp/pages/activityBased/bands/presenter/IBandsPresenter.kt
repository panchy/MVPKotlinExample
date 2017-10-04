package com.panch.kotlinmvp.pages.activityBased.bands.presenter

import com.panch.kotlinmvp.base.presenter.IBasePresenter
import com.panch.kotlinmvp.pages.activityBased.bands.model.Band

/**
 * Created by Panch on 1.10.2017.
 */
abstract class IBandsPresenter : IBasePresenter() {

    abstract fun bandsList(): List<Band>

}