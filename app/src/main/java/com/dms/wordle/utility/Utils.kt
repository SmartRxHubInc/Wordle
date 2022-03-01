package com.dms.wordle.utility

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.dms.wordle.ItemType
import com.dms.wordle.models.ChatItem
import com.dms.wordle.models.BoxesItem
import androidx.core.content.ContextCompat.getSystemService
import com.dms.wordle.models.AddCharInEdittext


object Utils {
    @JvmStatic
    fun boxesItem(verticalItem: Int, horizontalItem: Int): ArrayList<BoxesItem> {
        val mainItem = ArrayList<BoxesItem>()
        for (i in 1..verticalItem) {
            val dictionaryItem = BoxesItem();
            val charItem = ArrayList<ChatItem>()
            for (j in 1..horizontalItem) {
                charItem.add(ChatItem("", ItemType.GREY, 0))
            }
            dictionaryItem.charItem = charItem
            mainItem.add(dictionaryItem)
        }
        return mainItem
    }

    @JvmStatic
    fun boxItems(verticalItem: Int): ArrayList<ChatItem> {
        val charItem = ArrayList<ChatItem>()
        for (i in 1..verticalItem) {
            charItem.add(ChatItem("", ItemType.GREY, 0))
        }
        return charItem
    }

    @JvmStatic
    fun items(digitOfItem: Int): ArrayList<ChatItem> {
        val charItem = ArrayList<ChatItem>()
        for (i in 1..digitOfItem) {
            charItem.add(ChatItem("", ItemType.GREY, 0))
        }
        return charItem
    }

    fun hideKeyBoard(context: Context, view: View) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}