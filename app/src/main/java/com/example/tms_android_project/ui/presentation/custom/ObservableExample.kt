package com.example.tms_android_project.ui.presentation.custom

import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ObservableTester {

    fun test() {
        //Create the observable
        val testSingle: Single<String> = Single.just("Hello World")

        //Create an observer
        val disposable: Disposable = testSingle
            .delay(2, TimeUnit.SECONDS, Schedulers.io())
            .subscribeWith(
                object : DisposableSingleObserver<String?>() {
                    override fun onSuccess(value: String) {
                        println(value)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        Thread.sleep(3000)

        //start observing
        disposable.dispose()
    }
}