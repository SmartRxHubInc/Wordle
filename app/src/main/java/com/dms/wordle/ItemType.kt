package com.dms.wordle

import com.dms.wordle.interfaces.ItemColor

enum class ItemType(val diameter: Int) : ItemColor {
    GREY(1) {
        override fun getColors(): Int {
            return R.color.grey
        }
    },
    YELLOW(2) {
        override fun getColors(): Int {
            return R.color.yellow
        }
    },
    GREEN(3) {
        override fun getColors(): Int {
            return R.color.green
        }
    }
}