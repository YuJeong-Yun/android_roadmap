package com.bokchi.coco

import android.app.Application
import android.content.Context
import timber.log.Timber

/**
 * Timber로 로그 찍기 위한 준비
 */
class App : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun context(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}