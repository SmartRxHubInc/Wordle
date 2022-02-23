package com.dms.wordle.utility

import com.dms.wordle.ItemType
import com.dms.wordle.models.CharItem
import com.dms.wordle.models.BoxesItem

object Utils {
    @JvmStatic
    fun boxesItem(verticalItem: Int, horizontalItem: Int): ArrayList<BoxesItem> {
        val mainItem = ArrayList<BoxesItem>()
        for (i in 1..verticalItem) {
            val dictionaryItem = BoxesItem();
            val charItem = ArrayList<CharItem>()
            for (j in 1..horizontalItem) {
                charItem.add(CharItem("", ItemType.GREY, 0, false))
            }
            dictionaryItem.charItem = charItem
            mainItem.add(dictionaryItem)
        }
        return mainItem
    }
}