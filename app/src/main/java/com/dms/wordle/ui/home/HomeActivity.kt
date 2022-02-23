package com.dms.wordle.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import com.dms.wordle.BaseActivity
import com.dms.wordle.R
import com.dms.wordle.databinding.ActivityMainBinding
import android.widget.RadioButton
import androidx.databinding.BindingAdapter
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import kotlin.math.log


class HomeActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getDigitWiseDictionary()
        HomeRepository(this)
    }
}