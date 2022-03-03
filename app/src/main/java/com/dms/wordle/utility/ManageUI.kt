package com.dms.wordle.utility

import android.view.View
import com.dms.wordle.custom.GenericTextWatcher
import com.dms.wordle.custom.MyEditTextView
import com.dms.wordle.custom.MyKeyEvent
import com.dms.wordle.custom.MyNewKeyEvent
import com.dms.wordle.databinding.MyItemBinding
import com.dms.wordle.ui.home.HomeRepository

object ManageUI {
    fun manageTextEdit(
        digit: Int,
        position: Int,
        binding: MyItemBinding,
        homeRepository: HomeRepository
    ) {
        when (digit) {
            5 -> with(binding) {
//                cardView1.visibility = View.VISIBLE
//                cardView2.visibility = View.VISIBLE
//                cardView3.visibility = View.VISIBLE
//                cardView4.visibility = View.VISIBLE
//                cardView5.visibility = View.VISIBLE
//                cardView6.visibility = View.GONE
//                cardView7.visibility = View.GONE
//                cardView8.visibility = View.GONE
//

                editText.visibility = View.VISIBLE
                editText1.visibility = View.VISIBLE
                editText2.visibility = View.VISIBLE
                editText3.visibility = View.VISIBLE
                editText4.visibility = View.VISIBLE
                editText5.visibility = View.GONE
                editText6.visibility = View.GONE
                editText7.visibility = View.GONE

//                editText.addTextChangedListener(MyEditTextView(editText1, editText))
//                editText1.addTextChangedListener(MyEditTextView(editText2, editText))
//                editText2.addTextChangedListener(MyEditTextView(editText3, editText1))
//                editText3.addTextChangedListener(MyEditTextView(editText4, editText2))
//                editText4.addTextChangedListener(MyEditTextView(editText5, editText3))
//                editText5.addTextChangedListener(MyEditTextView(editText5, editText4))

                editText.addTextChangedListener(MyEditTextView(editText1, editText))
                editText1.addTextChangedListener(MyEditTextView(editText2, editText))
                editText2.addTextChangedListener(MyEditTextView(editText3, editText2))
                editText3.addTextChangedListener(MyEditTextView(editText4, editText2))
                editText4.addTextChangedListener(MyEditTextView(editText4, editText3))

                editText.setOnKeyListener(MyNewKeyEvent(editText, null, editText2))
                editText1.setOnKeyListener(MyNewKeyEvent(editText1, editText, editText2))
                editText2.setOnKeyListener(MyNewKeyEvent(editText2, editText1, editText3))
                editText3.setOnKeyListener(MyNewKeyEvent(editText3, editText2, editText4))
                editText4.setOnKeyListener(MyNewKeyEvent(editText4, editText3, null))
            }

            6 -> with(binding) {
//                cardView1.visibility = View.VISIBLE
//                cardView2.visibility = View.VISIBLE
//                cardView3.visibility = View.VISIBLE
//                cardView4.visibility = View.VISIBLE
//                cardView5.visibility = View.VISIBLE
//                cardView6.visibility = View.VISIBLE
//                cardView7.visibility = View.GONE
//                cardView8.visibility = View.GONE

                editText.visibility = View.VISIBLE
                editText1.visibility = View.VISIBLE
                editText2.visibility = View.VISIBLE
                editText3.visibility = View.VISIBLE
                editText4.visibility = View.VISIBLE
                editText5.visibility = View.VISIBLE
                editText6.visibility = View.GONE
                editText7.visibility = View.GONE

//                editText.addTextChangedListener(GenericTextWatcher(editText, editText1))
//                editText1.addTextChangedListener(GenericTextWatcher(editText1, editText2))
//                editText2.addTextChangedListener(GenericTextWatcher(editText2, editText3))
//                editText3.addTextChangedListener(GenericTextWatcher(editText3, editText4))
//                editText4.addTextChangedListener(GenericTextWatcher(editText4, editText5))
//                editText5.addTextChangedListener(GenericTextWatcher(editText5, editText5))

                editText.addTextChangedListener(MyEditTextView(editText1, editText))
                editText1.addTextChangedListener(MyEditTextView(editText2, editText))
                editText2.addTextChangedListener(MyEditTextView(editText3, editText1))
                editText3.addTextChangedListener(MyEditTextView(editText4, editText2))
                editText4.addTextChangedListener(MyEditTextView(editText5, editText3))
                editText5.addTextChangedListener(MyEditTextView(editText5, editText4))


                binding.editText.setOnKeyListener(MyKeyEvent(binding.editText, null))
                binding.editText1.setOnKeyListener(MyKeyEvent(binding.editText1, binding.editText))
                binding.editText2.setOnKeyListener(MyKeyEvent(binding.editText2, binding.editText1))
                binding.editText3.setOnKeyListener(MyKeyEvent(binding.editText3, binding.editText2))
                binding.editText4.setOnKeyListener(MyKeyEvent(binding.editText4, binding.editText3))
                binding.editText5.setOnKeyListener(MyKeyEvent(binding.editText5, binding.editText4))
            }

            7 -> with(binding) {
//                cardView1.visibility = View.VISIBLE
//                cardView2.visibility = View.VISIBLE
//                cardView3.visibility = View.VISIBLE
//                cardView4.visibility = View.VISIBLE
//                cardView5.visibility = View.VISIBLE
//                cardView6.visibility = View.VISIBLE
//                cardView7.visibility = View.VISIBLE
//                cardView8.visibility = View.GONE
//

                editText.visibility = View.VISIBLE
                editText1.visibility = View.VISIBLE
                editText2.visibility = View.VISIBLE
                editText3.visibility = View.VISIBLE
                editText4.visibility = View.VISIBLE
                editText5.visibility = View.VISIBLE
                editText6.visibility = View.VISIBLE
                editText7.visibility = View.GONE

                editText.addTextChangedListener(MyEditTextView(editText1, editText))
                editText1.addTextChangedListener(MyEditTextView(editText2, editText))
                editText2.addTextChangedListener(MyEditTextView(editText3, editText1))
                editText3.addTextChangedListener(MyEditTextView(editText4, editText2))
                editText4.addTextChangedListener(MyEditTextView(editText5, editText3))
                editText5.addTextChangedListener(MyEditTextView(editText6, editText4))
                editText6.addTextChangedListener(MyEditTextView(editText6, editText5))

                binding.editText.setOnKeyListener(MyKeyEvent(binding.editText, null))
                binding.editText1.setOnKeyListener(MyKeyEvent(binding.editText1, binding.editText))
                binding.editText2.setOnKeyListener(MyKeyEvent(binding.editText2, binding.editText1))
                binding.editText3.setOnKeyListener(MyKeyEvent(binding.editText3, binding.editText2))
                binding.editText4.setOnKeyListener(MyKeyEvent(binding.editText4, binding.editText3))
                binding.editText5.setOnKeyListener(MyKeyEvent(binding.editText5, binding.editText4))
                binding.editText6.setOnKeyListener(MyKeyEvent(binding.editText6, binding.editText5))
            }

            8 -> with(binding) {
//                cardView1.visibility = View.VISIBLE
//                cardView2.visibility = View.VISIBLE
//                cardView3.visibility = View.VISIBLE
//                cardView4.visibility = View.VISIBLE
//                cardView5.visibility = View.VISIBLE
//                cardView6.visibility = View.VISIBLE
//                cardView7.visibility = View.VISIBLE
//                cardView8.visibility = View.VISIBLE

                editText.visibility = View.VISIBLE
                editText1.visibility = View.VISIBLE
                editText2.visibility = View.VISIBLE
                editText3.visibility = View.VISIBLE
                editText4.visibility = View.VISIBLE
                editText5.visibility = View.VISIBLE
                editText6.visibility = View.VISIBLE
                editText7.visibility = View.VISIBLE

                editText.addTextChangedListener(MyEditTextView(editText1, editText))
                editText1.addTextChangedListener(MyEditTextView(editText2, editText))
                editText2.addTextChangedListener(MyEditTextView(editText3, editText1))
                editText3.addTextChangedListener(MyEditTextView(editText4, editText2))
                editText4.addTextChangedListener(MyEditTextView(editText5, editText3))
                editText5.addTextChangedListener(MyEditTextView(editText6, editText4))
                editText6.addTextChangedListener(MyEditTextView(editText7, editText5))
                editText7.addTextChangedListener(MyEditTextView(editText7, editText6))

                binding.editText.setOnKeyListener(MyKeyEvent(binding.editText, null))
                binding.editText1.setOnKeyListener(MyKeyEvent(binding.editText1, binding.editText))
                binding.editText2.setOnKeyListener(MyKeyEvent(binding.editText2, binding.editText1))
                binding.editText3.setOnKeyListener(MyKeyEvent(binding.editText3, binding.editText2))
                binding.editText4.setOnKeyListener(MyKeyEvent(binding.editText4, binding.editText3))
                binding.editText5.setOnKeyListener(MyKeyEvent(binding.editText5, binding.editText4))
                binding.editText6.setOnKeyListener(MyKeyEvent(binding.editText6, binding.editText5))
                binding.editText7.setOnKeyListener(MyKeyEvent(binding.editText7, binding.editText6))
            }
        }
    }
}