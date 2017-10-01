package com.panch.kotlinmvp.pages.activityBased.bands.presenter


import com.panch.kotlinmvp.base.callback.IBaseCallback
import com.panch.kotlinmvp.pages.activityBased.bands.model.IBandsModel
import com.panch.kotlinmvp.pages.activityBased.bands.model.Band
import com.panch.kotlinmvp.pages.activityBased.bands.model.BandsModel
import com.panch.kotlinmvp.pages.activityBased.bands.view.IBandsView

/**
 * Created by Panch on 1.10.2017.
 */
class BandsPresenter(bandsView: IBandsView) : IBandsPresenter() {

    private var mBandsModel: IBandsModel = BandsModel()
    private var mBandsView: IBandsView = bandsView

    override fun showcaseList(): List<Band> {
        return mBandsModel.showcaseList()
    }


    override fun initViewData() {
        mBandsView.hideError()
        mBandsView.showLoading()
        mBandsModel.requestShowcaseList(object : IBaseCallback<List<Band>> {
            override fun onSuccess(data: List<Band>) {
                mBandsView.onLoadSuccess(data)
                mBandsView.hideLoading()
            }

            override fun onFail(errorMessage: String?) {
                mBandsView.onLoadFail(errorMessage)
                mBandsView.hideLoading()
                mBandsView.showError()

            }
        })

    }

    override fun dispose() {
        mBandsModel.onDispose()
    }
}