package com.dms.wordle.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dms.wordle.BaseActivity
import com.dms.wordle.R
import com.dms.wordle.databinding.ActivityMainBinding
import com.dms.wordle.utility.Utils
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import java.util.*
import kotlin.math.log


class HomeActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getDigitWiseDictionary()
        Utils.alertDialog(this)
        HomeRepository(this)
    }
}