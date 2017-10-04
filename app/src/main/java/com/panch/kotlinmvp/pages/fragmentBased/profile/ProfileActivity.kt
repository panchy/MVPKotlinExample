package com.panch.kotlinmvp.pages.fragmentBased.profile

import android.os.Bundle
import com.panch.kotlinmvp.R
import com.panch.kotlinmvp.base.BaseActivity

class ProfileActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_profile
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragment()

    }

    private fun setFragment() {
        val supportFragmentManager = supportFragmentManager
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, ProfileFragment()).commit()
    }


}
