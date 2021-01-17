package com.a9ts.a9ts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter(
    private val items: List<ItemAdapter>
) : RecyclerView.Adapter<BaseViewHolder>() {

    final override fun getItemCount() = items.size

    final override fun getItemViewType(position: Int) = items[position].layoutId

    final override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return BaseViewHolder(view)
    }

    final override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        items[position].setupView(holder.view)
    }
}

abstract class ItemAdapter(@LayoutRes open val layoutId: Int) {
    abstract fun setupView(view: View)
}

class BaseViewHolder(val view: View) : RecyclerView.ViewHolder(view)