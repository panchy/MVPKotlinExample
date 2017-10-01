package com.panch.kotlinmvp.pages.activityBased.bands.model

import com.panch.kotlinmvp.base.callback.IBaseCallback
import com.panch.kotlinmvp.base.model.IBaseModel

/**
 * Created by Panch on 1.10.2017.
 */
interface IBandsModel : IBaseModel {

    fun requestShowcaseList(callback: IBaseCallback<List<Band>>)

    fun showcaseList(): List<Band>

}