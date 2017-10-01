package com.panch.kotlinmvp.pages.activityBased.bands.model

import com.panch.kotlinmvp.base.callback.IBaseCallback
import com.panch.kotlinmvp.base.model.BaseModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Panch on 1.10.2017.
 */
class BandsModel : BaseModel(), IBandsModel {

    var mData: ArrayList<Band> = ArrayList()

    override fun requestShowcaseList(callback: IBaseCallback<List<Band>>) {
        //Code below is to pretend some data is being requested.
        val disposable = Single.fromCallable({

            mData.clear()
            mData.add(Band(1, "Bring Me The Horizon", "http://i.axs.com/2015/11/promoted-media-optimized_565a2a438e37a.jpg"))
            mData.add(Band(2, "Our Last Night", "https://s3.amazonaws.com/bit-photos/large/7636667.jpeg"))
            mData.add(Band(3, "In Flames", "https://static1.squarespace.com/static/57f2b82b29687fb32444a615/t/58f10f6c20099e952f07869f/1492193139713/InFlames2017_bw.jpg"))
            mData.add(Band(4, "Ghost B.C.", "http://img.wennermedia.com/social/rs-159823-ghost-624-1380035316.jpg"))
            mData.add(Band(5, "Crown The Empire", "https://thisisnotyourscene.com/wp-content/uploads/2017/01/Crown-The-Empire-1165x665.jpg"))
            mData.add(Band(6, "Ill Nino", "http://www.metalinjection.net/wp-content/uploads/2014/06/Ill-Nino.jpg"))
            mData.add(Band(7, "Arch Enemy", "http://assets.blabbermouth.net/media/archenemyband2017promonew_638.jpg"))
            mData.add(Band(8, "Metallica", "https://i2.wp.com/www.metalinjection.net/wp-content/uploads/2017/02/metallica-2017-new.jpg?fit=700%2C367"))

            //To simulate if request fails or succeeds.
            val rd = Random()
            val N = rd.nextInt(10)
            return@fromCallable N
        })
                .subscribeOn(Schedulers.computation())
                .delay(1500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ N ->
                    if (N > 5) {
                        callback.onSuccess(showcaseList())
                    } else {
                        callback.onFail("An error has occured.")
                    }

                }, { T -> callback.onFail("An error occured.") })
        compositeDisposable.add(disposable)


    }

    override fun showcaseList(): List<Band> {
        return mData
    }

}