package com.example.lee.linenode

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_line_node.view.*

/**
 * Created by lee on 17-9-27.
 */
abstract class LineNodeAdapter<T>(val context: Context, val list: List<T>) : Adapter<LineNodeAdapter.LineNodeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LineNodeViewHolder {
        return LineNodeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_line_node, parent, false))
    }

    override fun onBindViewHolder(viewHolder: LineNodeViewHolder, position: Int) {
        convert(viewHolder, list.get(position))
    }


    abstract fun convert(viewHolder: LineNodeViewHolder, t: T)

    override fun getItemCount(): Int {
        return list.size
    }

    class LineNodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}