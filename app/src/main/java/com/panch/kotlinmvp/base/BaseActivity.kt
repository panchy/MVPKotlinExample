package com.panch.kotlinmvp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by Panch on 4.10.2017.
 */
abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    protected fun setFragment(layoutId:Int,fragment:Fragment){
        val supportFragmentManager = supportFragmentManager
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(layoutId,fragment).commit()
    }

}