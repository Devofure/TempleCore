package com.devofure.templecore

import com.devofure.templecore.di._core.AppComponent
import com.devofure.templecore.di._core.AppInjector
import com.devofure.templecore.di._core.DaggerApplication
import com.squareup.leakcanary.LeakCanary

class MainApplication : DaggerApplication() {

    //to be use when injecting custom components as Android Workers or Android Services
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
        component = AppInjector.init(this)
    }
}