package com.dms.wordle.ui.home

import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.dms.wordle.adapters.DictionaryAdapter
import com.dms.wordle.adapters.MyAdapter
import com.dms.wordle.models.DictionaryData
import com.dms.wordle.utility.Utils
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import java.util.ArrayList


class HomeRepository(private val homeActivity: HomeActivity) : RadioGroup.OnCheckedChangeListener {

    private var adapter: DictionaryAdapter = DictionaryAdapter(homeActivity.applicationContext)
    private lateinit var listOfDictionary: ArrayList<DictionaryData>

    val fiveOfList = Utils.items(5)
    val sixOfList = Utils.items(6)
    val sevenOfList = Utils.items(7)
    val eightOfList = Utils.items(8)

    var binding = homeActivity.binding

    init {
        binding.rg.setOnCheckedChangeListener(this)
        binding.rbFive.isChecked = true

        binding.rvWord.layoutManager = LinearLayoutManager(
            homeActivity.applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )

        MobileAds.initialize(homeActivity.applicationContext) {}
        binding.ads.loadAd(AdRequest.Builder().build())
        binding.ads.adListener = adListener()
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val checkedRadioButton = group?.findViewById<View>(checkedId) as RadioButton
        checkedRadioButton.isChecked
        listOfDictionary = homeActivity.digitWiseData(checkedRadioButton.text.toString().toInt())
        adapter.addItems(listOfDictionary)
        val listOfBoxes = Utils.boxItems(6)

        binding.rvWord.adapter = MyAdapter(
            homeActivity.applicationContext,
            this,
            listOfBoxes,
            checkedRadioButton.text.toString().toInt()
        )
        binding.rvFilter.adapter = adapter
    }

    private fun adListener(): AdListener {
        return object : AdListener() {
            override fun onAdLoaded() {
                binding.ads.visibility = View.VISIBLE
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.e("Load", adError.message + " " + adError.code)
            }

            override fun onAdOpened() {
                Log.e("Load", "IsOpen")
            }

            override fun onAdClicked() {
                Log.e("Load", "OnClick")
            }

            override fun onAdClosed() {
                Log.e("Load", "OnClose")
            }
        }
    }
}