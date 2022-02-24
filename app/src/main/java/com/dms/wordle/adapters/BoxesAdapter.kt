package com.dms.wordle.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dms.wordle.R
import com.dms.wordle.models.BoxesItem
import com.dms.wordle.models.ChatItem
import com.dms.wordle.viewHolders.BoxesViewHolder

class BoxesAdapter(var mContext: Context, private var mListOfBoxes: ArrayList<BoxesItem>) :
    RecyclerView.Adapter<BoxesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxesViewHolder {
        return BoxesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.boxes_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoxesViewHolder, position: Int) {
//        val adapter = CharAdapter(mContext, mListOfBoxes[position].charItem)
//        holder.binding.rvChar.layoutManager = LinearLayoutManager(
//            mContext,
//            RecyclerView.HORIZONTAL,
//            false
//        )
//        holder.binding.rvChar.adapter = adapter
    }

    override fun getItemCount(): Int {
        return mListOfBoxes.size
    }
}