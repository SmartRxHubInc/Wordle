package com.dms.wordle.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dms.wordle.appData.AppData

class SplashViewModel : ViewModel() {
    var isFinish = MutableLiveData<Boolean>()

    fun getStartTime() {
        Handler(Looper.myLooper()!!).postDelayed({
            isFinish.value = true
        }, (AppData.SPLASH_SCREEN_TIME))
    }
}