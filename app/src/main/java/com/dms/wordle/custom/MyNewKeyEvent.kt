package com.dms.wordle.custom

import android.view.KeyEvent
import android.view.View
import android.widget.EditText

class MyNewKeyEvent(private val currentView: EditText, private val previousView: EditText?,private val nextView: EditText?) :
    View.OnKeyListener {
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DEL && currentView.text.toString()
                .isEmpty()
        ) {
            previousView?.requestFocus()
            return true
        }

        if (keyCode != KeyEvent.KEYCODE_DEL && currentView.text.toString().isNotEmpty()) {
            nextView?.requestFocus()
        }
        return false
    }
}