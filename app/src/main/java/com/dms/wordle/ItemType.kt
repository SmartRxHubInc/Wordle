package com.dms.wordle

import com.dms.wordle.interfaces.ItemColor

enum class ItemType(val diameter: Int) : ItemColor {

    BLACK(0) {
        override fun getColors(): Int {
            return R.color.grey
        }
    },
    GREY(2) {
        override fun getColors(): Int {
            return R.color.grey
        }
    },
    YELLOW(3) {
        override fun getColors(): Int {
            return R.color.yellow
        }
    },
    GREEN(4) {
        override fun getColors(): Int {
            return R.color.green
        }
    }
}