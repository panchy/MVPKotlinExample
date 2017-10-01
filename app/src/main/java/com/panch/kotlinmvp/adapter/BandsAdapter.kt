package com.panch.kotlinmvp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.panch.kotlinmvp.R
import com.panch.kotlinmvp.pages.activityBased.bands.model.Band
import kotlinx.android.synthetic.main.item_showcase.view.*

/**
 * Created by Panch on 1.10.2017.
 */
class BandsAdapter(val context: Context, val list: List<Band>, val listener: AdapterItemListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_showcase, parent, false)
        return Item(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as Item).bindData(list[position], context, listener, position)
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(band: Band, context: Context, listener: AdapterItemListener, pos: Int) {

            Glide.with(context).load(band.imageUrl).into(itemView.imageview)

            itemView.textview.text = band.name

            itemView.setOnClickListener({
                listener.onItemClicked(pos)
            })

        }
    }
}