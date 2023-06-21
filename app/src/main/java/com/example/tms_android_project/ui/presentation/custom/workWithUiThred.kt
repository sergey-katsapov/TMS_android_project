package com.example.tms_android_project.ui.presentation.custom

import android.os.Handler
import android.os.HandlerThread

internal class workWithUiThred {
    fun uiThreadTest() {
        val handlerThread = HandlerThread(NAME_THREAD)

        handlerThread.start()

        val looper = handlerThread.looper
        val handler = Handler(looper)

        handler.post {
            // do something long-running here

        }
    }

//
//    class TestThread : Thread() {
//        override fun run() {}
//    }
//    //val thread = TestThread().start()

//    class MyRunnable : Runnable {
//        override fun run() {}
//    }
//    val myRunnableThread = Thread(MyRunnable())
//    //myRunnableThread.start()

    private companion object {
        private const val NAME_THREAD = "MyThread"
    }
}
