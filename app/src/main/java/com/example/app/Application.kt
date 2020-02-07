package com.example.app

import android.app.Application
import com.google.android.play.core.splitcompat.SplitCompat

class SampleApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.factory().create()
        super.onCreate()

        SplitCompat.install(this)
    }
}