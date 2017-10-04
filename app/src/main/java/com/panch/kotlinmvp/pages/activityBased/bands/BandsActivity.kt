package com.panch.kotlinmvp.pages.activityBased.bands

import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.panch.kotlinmvp.base.MVPBaseActivity
import com.panch.kotlinmvp.R
import com.panch.kotlinmvp.adapter.AdapterItemListener
import com.panch.kotlinmvp.adapter.BandsAdapter
import com.panch.kotlinmvp.pages.activityBased.bands.model.Band
import com.panch.kotlinmvp.pages.activityBased.bands.presenter.BandsPresenter
import com.panch.kotlinmvp.pages.activityBased.bands.view.IBandsView
import kotlinx.android.synthetic.main.activity_bands.*
import kotlinx.android.synthetic.main.error_view.*
import kotlinx.android.synthetic.main.loading_view.*

class BandsActivity : MVPBaseActivity<BandsPresenter>(), IBandsView, AdapterItemListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_bands
    }

    override fun initPresenter(): BandsPresenter {
        return BandsPresenter(this)
    }

    override fun onItemClicked(pos: Int) {

        val item = mPresenter.bandsList()[pos]
        showSnackbar(item.name)

    }

    override fun initView() {
        recyclerview_showcases.setHasFixedSize(true)
        recyclerview_showcases.layoutManager = GridLayoutManager(this, 2)
        recyclerview_showcases.adapter = BandsAdapter(this, mPresenter.bandsList(), this)

        mPresenter.initViewData()

        retryButton.setOnClickListener({
            mPresenter.initViewData()
        })
    }

    override fun showSnackbar(message: String) {

        Snackbar.make(root_layout, message, Snackbar.LENGTH_SHORT).show()

    }

    override fun onLoadSuccess(data: List<Band>) {

        //do something with data if you need.

        recyclerview_showcases.adapter.notifyDataSetChanged()

    }

    override fun onLoadFail(errorMessage: String?) {

        showSnackbar(errorMessage!!)

    }

    override fun showLoading() {
        loadingView.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loadingView.visibility = View.GONE
    }

    override fun showError() {
        errorView.visibility = View.VISIBLE
    }

    override fun hideError() {
        errorView.visibility = View.GONE
    }
}
