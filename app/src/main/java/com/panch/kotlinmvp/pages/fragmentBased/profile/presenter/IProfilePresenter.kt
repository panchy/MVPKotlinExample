package com.panch.kotlinmvp.pages.fragmentBased.profile.presenter

import com.panch.kotlinmvp.base.presenter.IBasePresenter
import com.panch.kotlinmvp.pages.fragmentBased.profile.model.Profile

/**
 * Created by Panch on 4.10.2017.
 */
abstract class IProfilePresenter : IBasePresenter() {

    abstract fun profileInfo(): Profile

}