package com.dms.wordle.custom

import android.view.KeyEvent
import android.view.View
import android.widget.EditText

class MyKeyEvent(private val currentView: EditText, private val previousView: EditText?) :
    View.OnKeyListener {
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DEL && currentView.text.toString()
                .isEmpty()
        ) {
            previousView?.requestFocus()
            return true
        }

        return false
    }
}