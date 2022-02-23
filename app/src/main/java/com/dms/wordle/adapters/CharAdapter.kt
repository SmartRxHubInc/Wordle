package com.dms.wordle.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dms.wordle.R
import com.dms.wordle.databinding.CharItemBinding
import com.dms.wordle.models.CharItem

class CharAdapter(var mContext: Context, var mListOfChar: ArrayList<CharItem>) :
    RecyclerView.Adapter<CharAdapter.CharViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        val binding: CharItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.char_item,
            parent,
            false
        )
        return CharViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CharViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        mListOfChar[position].id = holder.binding.etBox.id
        holder.binding.etBox.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    holder.binding.etBox.focusable = mListOfChar[position + 1].id
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    override fun getItemCount(): Int {
        return mListOfChar.size
    }

    class CharViewHolder(itemView: CharItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding: CharItemBinding = itemView

    }
}