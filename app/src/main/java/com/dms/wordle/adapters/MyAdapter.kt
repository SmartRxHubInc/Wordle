package com.dms.wordle.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dms.wordle.ItemType
import com.dms.wordle.R
import com.dms.wordle.custom.MyEditTextView
import com.dms.wordle.databinding.Item1Binding
import com.dms.wordle.models.ChatItem
import com.dms.wordle.ui.home.HomeRepository


class MyAdapter(
    private val mContext: Context,
    private val homeRepository: HomeRepository,
    private val mList: ArrayList<ChatItem>,
    private val digit: Int
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: Item1Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item1,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        setKeyboardAction(digit, holder.binding)

//        with(holder.binding) {
//            editText.onFocusChangeListener = FocusEditText(mContext, editText, holder.binding)
//            editText1.onFocusChangeListener = FocusEditText(mContext, editText1, holder.binding)
//            editText2.onFocusChangeListener = FocusEditText(mContext, editText2, holder.binding)
//            editText3.onFocusChangeListener = FocusEditText(mContext, editText3, holder.binding)
//            editText4.onFocusChangeListener = FocusEditText(mContext, editText4, holder.binding)
//            editText5.onFocusChangeListener = FocusEditText(mContext, editText5, holder.binding)
//            editText6.onFocusChangeListener = FocusEditText(mContext, editText6, holder.binding)
//            editText7.onFocusChangeListener = FocusEditText(mContext, editText7, holder.binding)
//        }

        when (digit) {
            5 -> with(holder.binding) {
                homeRepository.fiveOfList
                cardView1.visibility = View.VISIBLE
                cardView2.visibility = View.VISIBLE
                cardView3.visibility = View.VISIBLE
                cardView4.visibility = View.VISIBLE
                cardView5.visibility = View.VISIBLE
                cardView6.visibility = View.GONE
                cardView7.visibility = View.GONE
                cardView8.visibility = View.GONE
                editText.addTextChangedListener(
                    MyEditTextView(
                        editText1,
                        editText,
                        position,
                        0,
                        homeRepository.fiveOfList
                    )
                )
                editText1.addTextChangedListener(
                    MyEditTextView(
                        editText2,
                        editText,
                        position,
                        1,
                        homeRepository.fiveOfList
                    )
                )
                editText2.addTextChangedListener(
                    MyEditTextView(
                        editText3,
                        editText1,
                        position,
                        2,
                        homeRepository.fiveOfList
                    )
                )
                editText3.addTextChangedListener(
                    MyEditTextView(
                        editText4,
                        editText2,
                        position,
                        3,
                        homeRepository.fiveOfList
                    )
                )
                editText4.addTextChangedListener(
                    MyEditTextView(
                        editText4,
                        editText3,
                        position,
                        4,
                        homeRepository.fiveOfList
                    )
                )
            }

            6 -> with(holder.binding) {
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
            }

            7 -> with(holder.binding) {
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
            }

            8 -> with(holder.binding) {
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
            }
        }

        holder.binding.editText.setOnClickListener {
            setColor(holder.binding.editText, position, 0, digit)
        }

        holder.binding.editText1.setOnClickListener {
            setColor(holder.binding.editText1, position, 1, digit)
        }

        holder.binding.editText2.setOnClickListener {
            setColor(holder.binding.editText2, position, 2, digit)
        }

        holder.binding.editText3.setOnClickListener {
            setColor(holder.binding.editText3, position, 3, digit)
        }

        holder.binding.editText4.setOnClickListener {
            setColor(holder.binding.editText4, position, 4, digit)
        }

        holder.binding.editText5.setOnClickListener {
            setColor(holder.binding.editText5, position, 5, digit)
        }

        holder.binding.editText6.setOnClickListener {
            setColor(holder.binding.editText6, position, 6, digit)
        }

        holder.binding.editText7.setOnClickListener {
            setColor(holder.binding.editText7, position, 7, digit)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    private fun setColor(editText: EditText, position: Int, writePosition: Int, digit: Int) {
        if (digit == 5) {
            when (homeRepository.fiveOfList[writePosition].type) {
                ItemType.GREY -> homeRepository.fiveOfList[writePosition].type = ItemType.YELLOW
                ItemType.YELLOW -> homeRepository.fiveOfList[writePosition].type = ItemType.GREEN
                ItemType.GREEN -> homeRepository.fiveOfList[writePosition].type = ItemType.GREY
            }
            editText.backgroundTintList = ContextCompat.getColorStateList(mContext,homeRepository.fiveOfList[writePosition].type.getColors())
        }

        if (digit == 6) {
            when (homeRepository.sixOfList[writePosition].type) {
                ItemType.GREY -> homeRepository.sixOfList[writePosition].type = ItemType.YELLOW
                ItemType.YELLOW -> homeRepository.sixOfList[writePosition].type = ItemType.GREEN
                ItemType.GREEN -> homeRepository.sixOfList[writePosition].type = ItemType.GREY
            }
            editText.backgroundTintList = ContextCompat.getColorStateList(mContext,homeRepository.sixOfList[writePosition].type.getColors())
        }

        if (digit == 7) {
            when (homeRepository.sevenOfList[writePosition].type) {
                ItemType.GREY -> homeRepository.sevenOfList[writePosition].type = ItemType.YELLOW
                ItemType.YELLOW -> homeRepository.sevenOfList[writePosition].type = ItemType.GREEN
                ItemType.GREEN -> homeRepository.sevenOfList[writePosition].type = ItemType.GREY
            }
            editText.backgroundTintList = ContextCompat.getColorStateList(mContext, homeRepository.sevenOfList[writePosition].type.getColors())
        }

        if (digit == 8) {
            when (homeRepository.eightOfList[writePosition].type) {
                ItemType.GREY -> homeRepository.eightOfList[writePosition].type = ItemType.YELLOW
                ItemType.YELLOW -> homeRepository.eightOfList[writePosition].type = ItemType.GREEN
                ItemType.GREEN -> homeRepository.eightOfList[writePosition].type = ItemType.GREY
            }
            editText.backgroundTintList = ContextCompat.getColorStateList(mContext, homeRepository.eightOfList[writePosition].type.getColors())
        }
    }


    private fun setKeyboardAction(digit: Int, binding: Item1Binding) {
        if (digit == 5) {
            binding.editText4.imeOptions = EditorInfo.IME_ACTION_DONE
            binding.editText4.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    for (i in 0 until homeRepository.fiveOfList.size) {
                        if (ItemType.GREY == homeRepository.fiveOfList[i].type) {
                            Log.e("GREY size", i.toString())
                        }

                        if (ItemType.YELLOW == homeRepository.fiveOfList[i].type) {
                            Log.e("YELLOW size", i.toString())
                        }

                        if (ItemType.GREEN == homeRepository.fiveOfList[i].type) {
                            Log.e("GREEN size", i.toString())
                        }
                    }
                    true
                } else false
            }
        }

        if (digit == 6) {
            binding.editText5.imeOptions = EditorInfo.IME_ACTION_DONE
        }

        if (digit == 7) {
            binding.editText6.imeOptions = EditorInfo.IME_ACTION_DONE
        }

        if (digit == 8) {
            binding.editText7.imeOptions = EditorInfo.IME_ACTION_DONE
        }
    }

    class FocusEditText(private val mContext: Context, private val selectedEditText : EditText, val binding: Item1Binding) : View.OnFocusChangeListener {
        override fun onFocusChange(view: View?, isSelect: Boolean) {
                binding.editText.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.grey)
                binding.editText1.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.grey)
                binding.editText2.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.grey)
                binding.editText3.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.grey)
                binding.editText4.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.grey)
                binding.editText5.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.grey)
                binding.editText6.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.grey)
                binding.editText7.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.grey)
                selectedEditText.backgroundTintList = ContextCompat.getColorStateList(mContext, R.color.sky)
        }
    }
}