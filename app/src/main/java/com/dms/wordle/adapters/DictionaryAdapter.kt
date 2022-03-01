package com.dms.wordle.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dms.wordle.R
import com.dms.wordle.ui.home.HomeRepository
import com.dms.wordle.viewHolders.DictionaryViewHolder

class DictionaryAdapter(private val mContext: Context, private val homeRepository: HomeRepository) :
    RecyclerView.Adapter<DictionaryViewHolder>() {

    private val listOfItem = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder {
        return DictionaryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.dictionary_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        holder.binding.homeRepository = homeRepository
        holder.binding.item = listOfItem[position]
    }

    override fun getItemCount(): Int {
        return listOfItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: ArrayList<String>) {
        listOfItem.clear()
        listOfItem.addAll(items)
        notifyDataSetChanged()
    }
}