package com.dms.wordle.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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
            setColor(holder.binding.editText, position, 0)
        }

        holder.binding.editText1.setOnClickListener {
        }

        holder.binding.editText3.setOnClickListener {
            holder.binding.editText3.setBackgroundColor(Color.BLUE)
        }

        holder.binding.editText4.setOnClickListener {
            holder.binding.editText4.setBackgroundColor(Color.BLUE)
        }

        holder.binding.editText5.setOnClickListener {
            holder.binding.editText5.setBackgroundColor(Color.BLUE)
        }

        holder.binding.editText6.setOnClickListener {
            holder.binding.editText6.setBackgroundColor(Color.BLUE)
        }

        holder.binding.editText7.setOnClickListener {
            holder.binding.editText7.setBackgroundColor(Color.BLUE)
        }

        holder.binding.editText2.setOnClickListener {
            holder.binding.editText.setBackgroundColor(Color.BLUE)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    private fun setColor(editText: EditText, position: Int, writePosition: Int,) {
        when (homeRepository.fiveOfList[writePosition].type) {
            ItemType.BLACK -> homeRepository.fiveOfList[writePosition].type = ItemType.GREY
            ItemType.GREY -> homeRepository.fiveOfList[writePosition].type = ItemType.YELLOW
            ItemType.YELLOW -> homeRepository.fiveOfList[writePosition].type = ItemType.GREEN
            ItemType.GREEN -> homeRepository.fiveOfList[writePosition].type = ItemType.BLACK
        }
        editText.backgroundTintList = mContext.resources.getColorStateList( homeRepository.fiveOfList[writePosition].type.getColors())
    }

}