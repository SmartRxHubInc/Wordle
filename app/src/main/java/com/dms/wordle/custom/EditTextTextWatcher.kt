package com.dms.wordle.custom

import android.text.Editable
import android.text.TextWatcher
import com.dms.wordle.interfaces.IsTextWatcher

class EditTextTextWatcher(var isTextWatcher: IsTextWatcher, var position: Int) : TextWatcher {
    override fun afterTextChanged(editable: Editable) {
        val text = editable.toString()
        if (text.length == 1) {
            if (position == 7) {
                isTextWatcher.isWrite(position, true)
            } else {
                isTextWatcher.isWrite(position + 1, true)
            }
        } else if (text.isEmpty()) {
            if (position > 0) {
                isTextWatcher.isWrite(position + 1, false)
            } else {
                isTextWatcher.isWrite(position - 1, false)
            }
        }
    }

    override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}

    override fun onTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}
}