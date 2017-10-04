package com.panch.kotlinmvp.pages.fragmentBased.profile.presenter

import com.panch.kotlinmvp.base.callback.IBaseCallback
import com.panch.kotlinmvp.pages.fragmentBased.profile.model.IProfileModel
import com.panch.kotlinmvp.pages.fragmentBased.profile.model.Profile
import com.panch.kotlinmvp.pages.fragmentBased.profile.model.ProfileModel
import com.panch.kotlinmvp.pages.fragmentBased.profile.view.IProfileView

/**
 * Created by Panch on 4.10.2017.
 */
class ProfilePresenter(profileView: IProfileView) : IProfilePresenter() {

    private var mProfileView: IProfileView = profileView
    private var mProfileModel: IProfileModel = ProfileModel()

    override fun initViewData() {

        mProfileView.hideError()
        mProfileView.showLoading()
        mProfileModel.requestProfile(object : IBaseCallback<Profile> {
            override fun onSuccess(data: Profile) {
                mProfileView.onLoadSuccess(data)
                mProfileView.hideLoading()
            }

            override fun onFail(errorMessage: String?) {
                mProfileView.onLoadFail(errorMessage)
                mProfileView.hideLoading()
                mProfileView.showError()
            }

        })

    }

    override fun dispose() {
        mProfileModel.onDispose()
    }

    override fun profileInfo(): Profile {
        return mProfileModel.profile()
    }
}