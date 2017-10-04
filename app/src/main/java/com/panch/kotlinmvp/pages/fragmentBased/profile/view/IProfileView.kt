package com.panch.kotlinmvp.pages.fragmentBased.profile.view

import com.panch.kotlinmvp.base.view.IBaseView
import com.panch.kotlinmvp.pages.fragmentBased.profile.model.Profile

/**
 * Created by Panch on 4.10.2017.
 */
interface IProfileView : IBaseView {

    fun onLoadSuccess(data: Profile)
    fun onLoadFail(errorMessage: String?)

}