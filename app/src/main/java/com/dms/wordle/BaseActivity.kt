package com.dms.wordle

import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

open class BaseActivity : AppCompatActivity() {
    private val listDictionaryData = ArrayList<String>()
    fun getDigitWiseDictionary(): ArrayList<String>? {
        try {
            val inputStream: InputStream = assets.open("dictionary.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            val string = String(buffer)
            val jsonArray = JSONArray(string)

            for (i in 0 until jsonArray.length()) {
                if (jsonArray[i].toString().length > 4) {
                    if (!jsonArray[i].toString().contains(".") &&
                        !jsonArray[i].toString().contains("-") &&
                        !jsonArray[i].toString().contains("_")
                    ) {
                        listDictionaryData.add(jsonArray[i].toString())
                    }
                }
            }

            return listDictionaryData;
        } catch (e: IOException) {
            e.printStackTrace()
            return null;
        }
    }

    fun digitWiseData(limits: Int): ArrayList<String> {
        val dictionaryData = ArrayList<String>()
        if (listDictionaryData.isNotEmpty()) {
            dictionaryData.clear()
            for (i in 0 until listDictionaryData.size) {
                val haveDigit = listDictionaryData[i].filter { it.isDigit() }
                if (haveDigit.isEmpty() && listDictionaryData[i].length == limits) {
                    dictionaryData.add(listDictionaryData[i])
                }
            }
        } else {
            digitWiseData(limits)
        }
        return dictionaryData
    }
}