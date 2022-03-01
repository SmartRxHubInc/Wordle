package com.dms.wordle.utility

import android.view.View
import com.dms.wordle.custom.GenericTextWatcher
import com.dms.wordle.custom.MyEditTextView
import com.dms.wordle.custom.MyKeyEvent
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
                cardView1.visibility = View.VISIBLE
                cardView2.visibility = View.VISIBLE
                cardView3.visibility = View.VISIBLE
                cardView4.visibility = View.VISIBLE
                cardView5.visibility = View.VISIBLE
                cardView6.visibility = View.GONE
                cardView7.visibility = View.GONE
                cardView8.visibility = View.GONE


                editText.addTextChangedListener(GenericTextWatcher(editText, editText1))
                editText1.addTextChangedListener(GenericTextWatcher(editText1, editText2))
                editText2.addTextChangedListener(GenericTextWatcher(editText2, editText3))
                editText3.addTextChangedListener(GenericTextWatcher(editText3, editText4))
                editText4.addTextChangedListener(GenericTextWatcher(editText4, editText4))

                editText.setOnKeyListener(MyKeyEvent(editText, editText))
                editText1.setOnKeyListener(MyKeyEvent(editText1, editText))
                editText2.setOnKeyListener(MyKeyEvent(editText2, editText1))
                editText3.setOnKeyListener(MyKeyEvent(editText3, editText2))
                editText4.setOnKeyListener(MyKeyEvent(editText4, editText3))
            }

            6 -> with(binding) {
                cardView1.visibility = View.VISIBLE
                cardView2.visibility = View.VISIBLE
                cardView3.visibility = View.VISIBLE
                cardView4.visibility = View.VISIBLE
                cardView5.visibility = View.VISIBLE
                cardView6.visibility = View.VISIBLE
                cardView7.visibility = View.GONE
                cardView8.visibility = View.GONE
                editText.addTextChangedListener(
                    MyEditTextView(
                        editText1,
                        editText,
                        position,
                        0,
                        homeRepository.sixOfList
                    )
                )
                editText1.addTextChangedListener(
                    MyEditTextView(
                        editText2,
                        editText,
                        position,
                        1,
                        homeRepository.sixOfList
                    )
                )
                editText2.addTextChangedListener(
                    MyEditTextView(
                        editText3,
                        editText1,
                        position,
                        2,
                        homeRepository.sixOfList
                    )
                )
                editText3.addTextChangedListener(
                    MyEditTextView(
                        editText4,
                        editText2,
                        position,
                        3,
                        homeRepository.sixOfList
                    )
                )
                editText4.addTextChangedListener(
                    MyEditTextView(
                        editText5,
                        editText3,
                        position,
                        4,
                        homeRepository.sixOfList
                    )
                )
                editText5.addTextChangedListener(
                    MyEditTextView(
                        editText5,
                        editText4,
                        position,
                        5,
                        homeRepository.sixOfList
                    )
                )

                binding.editText.setOnKeyListener(MyKeyEvent(binding.editText, null))
                binding.editText1.setOnKeyListener(MyKeyEvent(binding.editText1, binding.editText))
                binding.editText2.setOnKeyListener(MyKeyEvent(binding.editText2, binding.editText1))
                binding.editText3.setOnKeyListener(MyKeyEvent(binding.editText3, binding.editText2))
                binding.editText4.setOnKeyListener(MyKeyEvent(binding.editText4, binding.editText3))
                binding.editText5.setOnKeyListener(MyKeyEvent(binding.editText5, binding.editText4))
            }

            7 -> with(binding) {
                cardView1.visibility = View.VISIBLE
                cardView2.visibility = View.VISIBLE
                cardView3.visibility = View.VISIBLE
                cardView4.visibility = View.VISIBLE
                cardView5.visibility = View.VISIBLE
                cardView6.visibility = View.VISIBLE
                cardView7.visibility = View.VISIBLE
                cardView8.visibility = View.GONE
                editText.addTextChangedListener(
                    MyEditTextView(
                        editText1,
                        editText,
                        position,
                        0,
                        homeRepository.sevenOfList
                    )
                )
                editText1.addTextChangedListener(
                    MyEditTextView(
                        editText2,
                        editText,
                        position,
                        1,
                        homeRepository.sevenOfList
                    )
                )
                editText2.addTextChangedListener(
                    MyEditTextView(
                        editText3,
                        editText1,
                        position,
                        2,
                        homeRepository.sevenOfList
                    )
                )
                editText3.addTextChangedListener(
                    MyEditTextView(
                        editText4,
                        editText2,
                        position,
                        3,
                        homeRepository.sevenOfList
                    )
                )
                editText4.addTextChangedListener(
                    MyEditTextView(
                        editText5,
                        editText3,
                        position,
                        4,
                        homeRepository.sevenOfList
                    )
                )
                editText5.addTextChangedListener(
                    MyEditTextView(
                        editText6,
                        editText4,
                        position,
                        5,
                        homeRepository.sevenOfList
                    )
                )
                editText6.addTextChangedListener(
                    MyEditTextView(
                        editText6,
                        editText5,
                        position,
                        6,
                        homeRepository.sevenOfList
                    )
                )

                binding.editText.setOnKeyListener(MyKeyEvent(binding.editText, null))
                binding.editText1.setOnKeyListener(MyKeyEvent(binding.editText1, binding.editText))
                binding.editText2.setOnKeyListener(MyKeyEvent(binding.editText2, binding.editText1))
                binding.editText3.setOnKeyListener(MyKeyEvent(binding.editText3, binding.editText2))
                binding.editText4.setOnKeyListener(MyKeyEvent(binding.editText4, binding.editText3))
                binding.editText5.setOnKeyListener(MyKeyEvent(binding.editText5, binding.editText4))
                binding.editText6.setOnKeyListener(MyKeyEvent(binding.editText6, binding.editText5))
            }

            8 -> with(binding) {
                cardView1.visibility = View.VISIBLE
                cardView2.visibility = View.VISIBLE
                cardView3.visibility = View.VISIBLE
                cardView4.visibility = View.VISIBLE
                cardView5.visibility = View.VISIBLE
                cardView6.visibility = View.VISIBLE
                cardView7.visibility = View.VISIBLE
                cardView8.visibility = View.VISIBLE

                editText.addTextChangedListener(
                    MyEditTextView(
                        editText1,
                        editText,
                        position,
                        0,
                        homeRepository.eightOfList
                    )
                )

                editText1.addTextChangedListener(
                    MyEditTextView(
                        editText2,
                        editText,
                        position,
                        1,
                        homeRepository.eightOfList
                    )
                )

                editText2.addTextChangedListener(
                    MyEditTextView(
                        editText3,
                        editText1,
                        position,
                        2,
                        homeRepository.eightOfList
                    )
                )

                editText3.addTextChangedListener(
                    MyEditTextView(
                        editText4,
                        editText2,
                        position,
                        3,
                        homeRepository.eightOfList
                    )
                )

                editText4.addTextChangedListener(
                    MyEditTextView(
                        editText5,
                        editText3,
                        position,
                        4,
                        homeRepository.eightOfList
                    )
                )

                editText5.addTextChangedListener(
                    MyEditTextView(
                        editText6,
                        editText4,
                        position,
                        5,
                        homeRepository.eightOfList
                    )
                )

                editText6.addTextChangedListener(
                    MyEditTextView(
                        editText7,
                        editText5,
                        position,
                        6,
                        homeRepository.eightOfList
                    )
                )
                editText7.addTextChangedListener(
                    MyEditTextView(
                        editText7,
                        editText6,
                        position,
                        7,
                        homeRepository.eightOfList
                    )
                )

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