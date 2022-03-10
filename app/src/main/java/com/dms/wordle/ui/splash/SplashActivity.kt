package com.dms.wordle.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.dms.wordle.BaseActivity
import com.dms.wordle.R
import com.dms.wordle.ui.home.HomeActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel.getStartTime()
        viewModel.isFinish.observe(this) {
            if (it) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }
    }
}