package com.dms.wordle.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import com.dms.wordle.BaseActivity
import com.dms.wordle.R
import com.dms.wordle.ui.demo.DemoActivity
import com.dms.wordle.ui.home.HomeActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        viewModel.getStartTime()
        viewModel.isFinish.observe(this, {
            if (it) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        })
    }
}