package com.dms.wordle.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dms.wordle.R
import com.dms.wordle.databinding.CharItemBinding
import com.dms.wordle.models.ChatItem

class CharAdapter(var mContext: Context, var mListOfChar: ArrayList<ChatItem>) :
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
    }

    override fun getItemCount(): Int {
        return mListOfChar.size
    }

    class CharViewHolder(itemView: CharItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding: CharItemBinding = itemView

    }
}