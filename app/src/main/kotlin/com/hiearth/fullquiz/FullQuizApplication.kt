package com.hiearth.fullquiz

import android.app.Application
import com.hiearth.fullquiz.core.local.SharedPreferenceManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FullQuizApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        SharedPreferenceManager.init(this)
    }
}