package com.panch.kotlinmvp.pages.fragmentBased.profile.view

import android.os.Bundle
import com.panch.kotlinmvp.R
import com.panch.kotlinmvp.base.BaseActivity

class ProfileActivity : BaseActivity() {

    override fun getLayoutId(): Int =  R.layout.activity_profile


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragment(R.id.container, ProfileFragment())
    }
}
