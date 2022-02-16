package com.digimaster.daylima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digimaster.daylima.databinding.ItemComplainBinding
import com.digimaster.daylima.databinding.ItemjobBinding
import com.digimaster.daylima.model.Data

class JobAdapter : RecyclerView.Adapter<JobAdapter.ViewHolder>() {
    var list = arrayListOf<Data>()
    private var context: Context? = null

    inner class ViewHolder(val binding: ItemjobBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
//            binding.root.setOnClickListener {
//                onItemClickListener?.let { it(da[adapterPosition].eventId) }
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
           ItemjobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                var imageArray: ArrayList<String> = ArrayList<String>()
                binding.tvText.text = jobName

        }
    }}

    override fun getItemCount() = list.size

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    fun initData(llist: ArrayList<Data>) {
        this.list = llist
        notifyDataSetChanged()
    }


}