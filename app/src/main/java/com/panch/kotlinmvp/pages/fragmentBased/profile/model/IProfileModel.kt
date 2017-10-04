package com.panch.kotlinmvp.pages.fragmentBased.profile.model

import com.panch.kotlinmvp.base.callback.IBaseCallback
import com.panch.kotlinmvp.base.model.IBaseModel

/**
 * Created by Panch on 4.10.2017.
 */
interface IProfileModel : IBaseModel {

    fun requestProfile(callback: IBaseCallback<Profile>)

    fun profile(): Profile

}