package com.example.newsreader

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


class RecylerviewAdapter(
    var childlayout: Int, private var itemsList: ObservableArrayList<*>,
    val eventHandler: EventHandler,
    val dataPoolDataHandler: DatapooldataHandler
) :
    RecyclerView.Adapter<RecylerviewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(
                inflater, childlayout, parent,
                false
            )
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(p0: RecyclerViewHolder, p1: Int) {
        val item = itemsList[p1]
        p0.bind(item, p1)
    }

    inner class RecyclerViewHolder(val viewBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: Any, position: Int) {
            viewBinding.setVariable(BR.clickHandler, eventHandler)
            viewBinding.setVariable(BR.datapoolHandler, dataPoolDataHandler)
            viewBinding.setVariable(BR.position, position)
            viewBinding.setVariable(BR.obj, item)
        }
    }
}