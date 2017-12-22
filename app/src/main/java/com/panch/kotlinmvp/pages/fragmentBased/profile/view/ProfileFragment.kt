package com.panch.kotlinmvp.pages.fragmentBased.profile.view


import android.content.Intent
import android.support.design.widget.Snackbar
import android.view.View
import com.bumptech.glide.Glide
import com.panch.kotlinmvp.R
import com.panch.kotlinmvp.base.MVPBaseFragment
import com.panch.kotlinmvp.pages.activityBased.bands.BandsActivity
import com.panch.kotlinmvp.pages.fragmentBased.profile.model.Profile
import com.panch.kotlinmvp.pages.fragmentBased.profile.presenter.ProfilePresenter
import kotlinx.android.synthetic.main.error_view.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.loading_view.*


class ProfileFragment : MVPBaseFragment<ProfilePresenter>(), IProfileView {

    override fun getLayoutId(): Int {
        return R.layout.fragment_profile
    }

    override fun showSnackbar(message: String) {
        Snackbar.make(root_layout, message, Snackbar.LENGTH_SHORT).show()
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

    override fun onLoadSuccess(data: Profile) {

        Glide.with(activity).load(data.profilePictureUrl).into(avatarImageView)
        val nameAndSurname = data.name + " " + data.surname
        nameSurnameTextView.text = nameAndSurname
        nicknameTextView.text = data.nickname
        favoriteBandsButton.setOnClickListener({
            val favBandsIntent = Intent(activity, BandsActivity::class.java)
            startActivity(favBandsIntent)
        })

    }

    override fun onLoadFail(errorMessage: String?) {
        showSnackbar(errorMessage!!)
    }

    override fun initView() {
        mPresenter.initViewData()
        retryButton.setOnClickListener({
            mPresenter.initViewData()
        })
    }

    override fun initPresenter(): ProfilePresenter {

        return ProfilePresenter(this)

    }
}
