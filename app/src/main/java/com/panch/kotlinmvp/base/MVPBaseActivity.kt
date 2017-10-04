package com.panch.kotlinmvp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.panch.kotlinmvp.base.presenter.IBasePresenter

/**
 * Created by Panch on 1.10.2017.
 */
abstract class MVPBaseActivity<T : IBasePresenter> : AppCompatActivity() {

    protected lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mPresenter = initPresenter()
        initView()
    }

    abstract fun initPresenter(): T

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initView()

    override fun onDestroy() {
        mPresenter.dispose()
        super.onDestroy()
    }
}