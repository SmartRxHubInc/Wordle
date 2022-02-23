package com.dms.wordle.ui.home

import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dms.wordle.adapters.BoxesAdapter
import com.dms.wordle.adapters.DictionaryAdapter
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

    var binding = homeActivity.binding

    init {
        binding.rg.setOnCheckedChangeListener(this)
        binding.rbFive.isChecked = true
        binding.rvWord.layoutManager = LinearLayoutManager(
            homeActivity.applicationContext,
            RecyclerView.VERTICAL,
            false
        )
        val listOfBoxes = Utils.boxesItem(7, 5)
        val boxesAdapter = BoxesAdapter(homeActivity.applicationContext, listOfBoxes)

        binding.rvWord.adapter = boxesAdapter
        binding.rvFilter.adapter = adapter
        MobileAds.initialize(homeActivity.applicationContext) {}
        binding.ads.loadAd(AdRequest.Builder().build())
        binding.ads.adListener = adListener()


        val rows: ArrayList<TableRow> = ArrayList<TableRow>()
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        for (i in 1..6) {
            val name = EditText(homeActivity)
            val time = EditText(homeActivity)
            val row = TableRow(homeActivity)
            rows.add(row)

            // Set event name and remaining time
//            name.text = i.toString()
//            time.text = "..."
            // Add text views to row
            row.addView(time, layoutParams)
            row.addView(name, layoutParams)
            binding.tableview.addView(row, i)
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val checkedRadioButton = group?.findViewById<View>(checkedId) as RadioButton
        checkedRadioButton.isChecked
        listOfDictionary = homeActivity.digitWiseData(checkedRadioButton.text.toString().toInt())
        adapter.addItems(listOfDictionary)
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