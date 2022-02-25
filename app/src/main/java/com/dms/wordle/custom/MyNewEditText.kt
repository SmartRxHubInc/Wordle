package com.dms.wordle.custom

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.dms.wordle.models.ChatItem


class MyEditTextView(
    private val etNext: EditText,
    private val etPrev: EditText,
    var position: Int,
    var writePosition: Int,
    var list: ArrayList<ChatItem>
) : TextWatcher {
    override fun afterTextChanged(editable: Editable) {
        val text = editable.toString()
        if (text.length == 1) {
            etNext.requestFocus()
        } else if (text.isEmpty()) {
            etPrev.requestFocus()
        }
        list[writePosition].char = text
    }

    override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}

    override fun onTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}
}