package com.orgustine.hagglex.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orgustine.hagglex.data.mdel.DoMore
import com.orgustine.hagglex.databinding.DoMoreItemLayoutBinding

class DoMoreAdapter(private val list: List<DoMore>) : RecyclerView.Adapter<DoMoreAdapter.ViewHolder>() {

    class ViewHolder(private val binding: DoMoreItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(more: DoMore) {
            binding.apply {
                logo.setImageResource(more.logo)
                title.text = more.title
                subTitle.text = more.subtitle
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DoMoreItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size
}