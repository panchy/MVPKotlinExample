package com.panch.kotlinmvp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panch.kotlinmvp.base.presenter.IBasePresenter

/**
 * Created by Panch on 4.10.2017.
 */
abstract class MVPBaseFragment<T : IBasePresenter> : Fragment() {

    protected lateinit var mPresenter: T

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = initPresenter()
        initView()
    }

    abstract fun initView()

    override fun onDestroy() {
        mPresenter.dispose()
        super.onDestroy()
    }

    abstract fun initPresenter(): T
}