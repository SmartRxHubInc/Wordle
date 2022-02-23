package com.dms.wordle.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dms.wordle.R
import com.dms.wordle.databinding.DictionaryItemBinding
import com.dms.wordle.models.DictionaryData
import com.dms.wordle.viewHolders.DictionaryViewHolder

class DictionaryAdapter(private val mContext: Context) :
    RecyclerView.Adapter<DictionaryViewHolder>() {

    private val listOfItem = ArrayList<DictionaryData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder {
        return DictionaryViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.dictionary_item,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        holder.binding.item = listOfItem[position]
    }

    override fun getItemCount(): Int {
        return listOfItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: ArrayList<DictionaryData>) {
        listOfItem.clear()
        listOfItem.addAll(items)
        notifyDataSetChanged()
    }
}