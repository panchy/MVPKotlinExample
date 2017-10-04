package com.panch.kotlinmvp.pages.fragmentBased.profile.model

import com.panch.kotlinmvp.base.callback.IBaseCallback
import com.panch.kotlinmvp.base.model.BaseModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Panch on 4.10.2017.
 */
class ProfileModel : BaseModel(), IProfileModel {

    var mData: Profile = Profile(
            1,
            "https://scontent.fsaw1-8.fna.fbcdn.net/v/t1.0-9/15267967_560119470845905_4378654122662603813_n.jpg?oh=31f191f52ee78e98c12a195ef736c0f2&oe=5A4CFCA1",
            "Yiğit Can",
            "Parıltı",
            "Panch"
    )

    override fun onDispose() {
        compositeDisposable.dispose()
    }

    override fun requestProfile(callback: IBaseCallback<Profile>) {
        val disposable = Single.fromCallable({
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
                        callback.onSuccess(profile())
                    } else {
                        callback.onFail("An error has occured.")
                    }

                }, { T -> callback.onFail("An error occured.") })
        compositeDisposable.add(disposable)
    }

    override fun profile(): Profile {
        return mData
    }
}