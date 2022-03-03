package com.dms.wordle.ui.home

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dms.wordle.ItemType
import com.dms.wordle.adapters.DictionaryAdapter
import com.dms.wordle.adapters.MyAdapter
import com.dms.wordle.appData.MainLogic.filterData
import com.dms.wordle.custom.GenericTextWatcher
import com.dms.wordle.custom.MyKeyEvent
import com.dms.wordle.databinding.MyItemBinding
import com.dms.wordle.models.AddCharInEdittext
import com.dms.wordle.models.PerfectPosition
import com.dms.wordle.models.YellowPosition
import com.dms.wordle.utility.Utils
import com.dms.wordle.utility.ValidationEditText
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds


class HomeRepository(private val homeActivity: HomeActivity) :
    RadioGroup.OnCheckedChangeListener {

    private val grey = ArrayList<String>()

    private val yellow = ArrayList<YellowPosition>()

    private val green = ArrayList<PerfectPosition>()

    val addCharInEdittext = ArrayList<AddCharInEdittext>()

    private var digit: Int = 5

    private var currentPosition = 0

    private var adapter: DictionaryAdapter =
        DictionaryAdapter(homeActivity.applicationContext, this)
    private lateinit var listOfDictionary: ArrayList<String>
    var listOfBoxes = Utils.boxItems(6)


    var fiveOfList = Utils.items(5)
    var sixOfList = Utils.items(6)
    var sevenOfList = Utils.items(7)
    var eightOfList = Utils.items(8)

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

        binding.btnFilter.setOnClickListener {
            for (i in grey.indices) {
                Log.e("Grey Char : ", grey[i])
            }
            Log.e("<-----------> : ", "<----------->")

            for (i in yellow.indices) {
                Log.e("Yellow Char : ", yellow[i].char)

            }
            Log.e("<-----------> : ", "<----------->")

            for (i in green.indices) {
                Log.e("Green Char : ", green[i].char)
            }

            if (ValidationEditText.validation(
                    digit = digit,
                    editText = addCharInEdittext[currentPosition].editText
                )
            ) {
                getWord()
            } else {
                Toast.makeText(homeActivity.applicationContext, "Fill the row ", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.ivRefresh.setOnClickListener {
            grey.clear()
            yellow.clear()
            green.clear()
            currentPosition = 0
            listOfDictionary.clear()
            binding.rbFive.isChecked = true
            listOfDictionary = homeActivity.digitWiseData(5)
            adapter.addItems(listOfDictionary)
            listOfBoxes.clear()
            listOfBoxes = Utils.boxItems(6)
            addCharInEdittext.clear()
            binding.rvWord.adapter = MyAdapter(
                homeActivity.applicationContext,
                this,
                listOfBoxes,
                5
            )
        }

    }

    private fun callFilter() {

    }

    private fun getWord() {
        when (digit) {
            5 -> {
                for (i in 0 until fiveOfList.size) {
                    addInList1(
                        i,
                        fiveOfList[i].type,
                        addCharInEdittext[currentPosition].editText
                    )
                }
                fiveOfList.clear()
                fiveOfList = Utils.items(5)
            }

            6 -> {
                for (i in 0 until sixOfList.size) {
                    addInList1(i, sixOfList[i].type, addCharInEdittext[currentPosition].editText)
                }
                sixOfList.clear()
                sixOfList = Utils.items(6)
            }

            7 -> {
                for (i in 0 until sevenOfList.size) {
                    addInList1(i, sevenOfList[i].type, addCharInEdittext[currentPosition].editText)
                }
                sevenOfList.clear()
                sevenOfList = Utils.items(7)
            }

            8 -> {
                for (i in 0 until eightOfList.size) {
                    addInList1(i, eightOfList[i].type, addCharInEdittext[currentPosition].editText)
                }
                eightOfList.clear()
                eightOfList = Utils.items(8)
            }
        }
        checkIsWrite(currentPosition)

        listOfDictionary.clear()
        val list = filterData(grey, yellow, green, getList(digit))
        listOfDictionary.addAll(list)
        adapter.addItems(listOfDictionary)
        enableRow()
    }

    private fun addInList1(position: Int, itemType: ItemType, editText: ArrayList<EditText>) {
        val first = editText[0].text.toString()
        val second = editText[1].text.toString()
        val three = editText[2].text.toString()
        val four = editText[3].text.toString()
        val five = editText[4].text.toString()
        val six = editText[5].text.toString()
        val seven = editText[6].text.toString()
        val eight = editText[7].text.toString()


        if (position == 0) {
            addColorWiseList(
                first,
                itemType,
                YellowPosition(position, first),
                PerfectPosition(position, first)
            )
        }

        if (position == 1) {
            addColorWiseList(
                second,
                itemType,
                YellowPosition(position, second),
                PerfectPosition(position, second)
            )
        }

        if (position == 2) {
            addColorWiseList(
                three,
                itemType,
                YellowPosition(position, three),
                PerfectPosition(position, three)
            )
        }

        if (position == 3) {
            addColorWiseList(
                four,
                itemType,
                YellowPosition(position, four),
                PerfectPosition(position, four)
            )
        }
        if (position == 4) {
            addColorWiseList(
                five,
                itemType,
                YellowPosition(position, five),
                PerfectPosition(position, five)
            )
        }

        if (position == 5) {
            addColorWiseList(
                six,
                itemType,
                YellowPosition(position, six),
                PerfectPosition(position, six)
            )
        }

        if (position == 6) {
            addColorWiseList(
                seven,
                itemType,
                YellowPosition(position, seven),
                PerfectPosition(position, seven)
            )
        }

        if (position == 7) {
            addColorWiseList(
                eight,
                itemType,
                YellowPosition(position, eight),
                PerfectPosition(position, eight)
            )
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val checkedRadioButton = group?.findViewById<View>(checkedId) as RadioButton
        checkedRadioButton.isChecked
        digit = checkedRadioButton.text.toString().toInt()
        listOfDictionary = homeActivity.digitWiseData(checkedRadioButton.text.toString().toInt())
        adapter.addItems(listOfDictionary)
        addCharInEdittext.clear()
        listOfBoxes.clear()
        listOfBoxes = Utils.boxItems(6)
        currentPosition = 0
        binding.rvWord.adapter = MyAdapter(
            homeActivity.applicationContext,
            this,
            listOfBoxes,
            checkedRadioButton.text.toString().toInt()
        )
        binding.rvFilter.adapter = adapter


        Handler(Looper.myLooper()!!).postDelayed({
            enableRow()
            getCurrentPosition()
        }, 2000)

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

    fun addInList(position: Int, itemType: ItemType, binding: MyItemBinding) {
        val first = binding.editText.text.toString()
        val second = binding.editText1.text.toString()
        val three = binding.editText2.text.toString()
        val four = binding.editText3.text.toString()
        val five = binding.editText4.text.toString()
        val six = binding.editText5.text.toString()
        val seven = binding.editText6.text.toString()
        val eight = binding.editText7.text.toString()

        if (position == 0) {
            addColorWiseList(
                first,
                itemType,
                YellowPosition(position, first),
                PerfectPosition(position, first)
            )
        }

        if (position == 1) {
            addColorWiseList(
                second,
                itemType,
                YellowPosition(position, second),
                PerfectPosition(position, second)
            )
        }

        if (position == 2) {
            addColorWiseList(
                three,
                itemType,
                YellowPosition(position, three),
                PerfectPosition(position, three)
            )
        }

        if (position == 3) {
            addColorWiseList(
                four,
                itemType,
                YellowPosition(position, four),
                PerfectPosition(position, four)
            )
        }
        if (position == 4) {
            addColorWiseList(
                five,
                itemType,
                YellowPosition(position, five),
                PerfectPosition(position, five)
            )
        }

        if (position == 5) {
            addColorWiseList(
                six,
                itemType,
                YellowPosition(position, six),
                PerfectPosition(position, six)
            )
        }

        if (position == 6) {
            addColorWiseList(
                seven,
                itemType,
                YellowPosition(position, seven),
                PerfectPosition(position, seven)
            )
        }

        if (position == 7) {
            addColorWiseList(
                eight,
                itemType,
                YellowPosition(position, eight),
                PerfectPosition(position, eight)
            )
        }
    }

    private fun addColorWiseList(
        value: String,
        itemType: ItemType,
        yellowPosition: YellowPosition,
        perfectPosition: PerfectPosition
    ) {
        when (itemType) {
            ItemType.GREY -> if (checkGreyList(value)) {
                grey.add(value)
            }

            ItemType.YELLOW -> if (checkYellowList(yellowPosition)) {
                yellow.add(yellowPosition)
            }

            ItemType.GREEN -> if (checkGreenList(perfectPosition)) {
                green.add(perfectPosition)
            }
        }
    }

    private fun checkGreyList(value: String): Boolean {
        val greyFound = grey.filter { it == value }
        return greyFound.isEmpty()
    }

    private fun checkYellowList(value: YellowPosition): Boolean {
        val yellowFound = yellow.filter { it == value }
        return yellowFound.isEmpty()
    }

    private fun checkGreenList(value: PerfectPosition): Boolean {
        val greenFound = green.filter { it == value }
        return greenFound.isEmpty()
    }

    private fun getList(digit: Int): ArrayList<String> {
        return homeActivity.digitWiseData(digit)
    }

    fun checkIsWrite(position: Int) {
        var newList = String()
        for (i in 0 until addCharInEdittext[position].editText.size) {
            newList += addCharInEdittext[position].editText[i].text.toString()
        }
        addCharInEdittext[position].word = newList
        getCurrentPosition()
    }

    private fun getCurrentPosition(): Int {
        currentPosition = 0
        for (i in addCharInEdittext.indices) {
            if (addCharInEdittext[i].word == "") {
                currentPosition = i
                break
            }
        }
        return currentPosition
    }

    fun onWordClick(item: String) {
        var position = 0
        for (i in 0 until addCharInEdittext.size) {
            if (addCharInEdittext[i].word == "") {
                position = i
                break
            }
        }

        for (i in item.indices) {
            for (j in 0 until addCharInEdittext[position].editText.size) {
                if (i == j) {
                    addCharInEdittext[position].editText[j].setText(item[i].toString())
                }
            }

//            for (j in addCharInEdittext[position].editText.indices) {
//                if (i == 0) {
//                    addCharInEdittext[position].binding.editText.setText(item[i].toString())
//                }
//
//                if (i == 1) {
//                    addCharInEdittext[position].binding.editText1.setText(item[i].toString())
//                }
//
//                if (i == 2) {
//                    addCharInEdittext[position].binding.editText2.setText(item[i].toString())
//                }
//
//                if (i == 3) {
//                    addCharInEdittext[position].binding.editText3.setText(item[i].toString())
//                }
//
//                if (i == 4) {
//                    addCharInEdittext[position].binding.editText4.setText(item[i].toString())
//                }
//
//                if (i == 5) {
//                    addCharInEdittext[position].binding.editText5.setText(item[i].toString())
//                }
//
//                if (i == 6) {
//                    addCharInEdittext[position].binding.editText6.setText(item[i].toString())
//                }
//
//                if (i == 7) {
//                    addCharInEdittext[position].binding.editText7.setText(item[i].toString())
//                }
//            }
        }
    }

    private fun enableRow() {
        for (i in addCharInEdittext.indices) {
            for (j in addCharInEdittext[i].editText.indices) {
                addCharInEdittext[i].editText[j].isEnabled = currentPosition == i
            }
        }
    }
}