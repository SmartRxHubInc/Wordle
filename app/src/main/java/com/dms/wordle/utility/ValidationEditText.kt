package com.dms.wordle.utility

import android.widget.EditText

object ValidationEditText {
    fun validation(digit: Int, editText: ArrayList<EditText>): Boolean {
        if (digit == 5) {
            if (editText.size > 4) {
                return editText[0].text.isNotEmpty() &&
                        editText[1].text.isNotEmpty() &&
                        editText[2].text.isNotEmpty() &&
                        editText[3].text.isNotEmpty() &&
                        editText[4].text.isNotEmpty()
            }
        }

        if (digit == 6) {
            if (editText.size > 5) {
                return editText[0].text.isNotEmpty() &&
                        editText[1].text.isNotEmpty() &&
                        editText[2].text.isNotEmpty() &&
                        editText[3].text.isNotEmpty() &&
                        editText[4].text.isNotEmpty() &&
                        editText[5].text.isNotEmpty()
            }
        }

        if (digit == 7) {
            if (editText.size > 6) {
                return editText[0].text.isNotEmpty() &&
                        editText[1].text.isNotEmpty() &&
                        editText[2].text.isNotEmpty() &&
                        editText[3].text.isNotEmpty() &&
                        editText[4].text.isNotEmpty() &&
                        editText[5].text.isNotEmpty() &&
                        editText[6].text.isNotEmpty()
            }
        }

         if (digit == 8) {
            if (editText.size > 7) {
                return editText[0].text.isNotEmpty() &&
                        editText[1].text.isNotEmpty() &&
                        editText[2].text.isNotEmpty() &&
                        editText[3].text.isNotEmpty() &&
                        editText[4].text.isNotEmpty() &&
                        editText[5].text.isNotEmpty() &&
                        editText[6].text.isNotEmpty() &&
                        editText[7].text.isNotEmpty()
            }
        }
        return false
    }
}