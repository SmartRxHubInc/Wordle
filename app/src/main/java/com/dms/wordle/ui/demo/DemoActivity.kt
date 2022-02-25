package com.dms.wordle.ui.demo

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.dms.wordle.BaseActivity
import com.dms.wordle.ItemType
import com.dms.wordle.R
import com.dms.wordle.adapters.DictionaryAdapter
import com.dms.wordle.databinding.ActivityDemoBinding
import com.dms.wordle.utility.Utils

class DemoActivity : BaseActivity() {
    lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo)
        getDigitWiseDictionary()
        val adapter = DictionaryAdapter(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView1.adapter = adapter
        val listOfDictionary = digitWiseData(5)
        adapter.addItems(listOfDictionary)

        val dictionaryList = Utils.boxesItem(6, 5)
        dictionaryList[0].charItem[0].type = ItemType.GREEN
        Log.e("Size of list : ", dictionaryList.size.toString())
        Log.e("Size of list : ", dictionaryList.size.toString())
        Log.e("Name : ", dictionaryList[0].charItem[0].type.name)
        Log.e("Diameter : ", dictionaryList[0].charItem[0].type.diameter.toString())

        binding.box.setOnClickListener { }
        binding.box.setOnClickListener() { }
    }
}