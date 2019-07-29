package com.felipearaujo.newsapp.sources

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.felipearaujo.model.Source
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.databinding.ItemSourceBinding


/**
 * Created by felipearaujo on 07/11/17.
 */
class SourcesAdapter(private val mView: SourcesView) : RecyclerView.Adapter<SourcesAdapter.SourcesViewHolder>() {

    private val mSourcesList = ArrayList<Source>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemSourceBinding>(inflater, R.layout.item_source, parent, false)
        return SourcesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        val source = mSourcesList[position]
        holder.bind(source)
        holder.itemView?.setOnClickListener {
            mView.onItemClick(source)
        }
    }

    override fun getItemCount(): Int = mSourcesList.size

    fun addSources(newItems: List<Source>) {
        mSourcesList.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class SourcesViewHolder(private val itemSourceBinding: ItemSourceBinding) : RecyclerView.ViewHolder(itemSourceBinding.root) {

        fun bind(item: Source) {
            itemSourceBinding.source = item
            itemSourceBinding.executePendingBindings()
        }

    }

}