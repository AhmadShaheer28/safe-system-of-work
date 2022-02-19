package com.safe.systemOfWork.app

import android.app.Application
import android.content.Context
import android.os.StrictMode

class App: Application() {
    companion object {
        var appContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
//        SharedPrefManager.getInstance(applicationContext)
        val builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
    }
}