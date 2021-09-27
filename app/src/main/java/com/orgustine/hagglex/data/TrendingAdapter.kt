package com.orgustine.hagglex.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orgustine.hagglex.data.mdel.TrendingNews
import com.orgustine.hagglex.databinding.TrendingNewsItemLayoutBinding

class TrendingAdapter(private val list: List<TrendingNews>) : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    class ViewHolder(private val binding: TrendingNewsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: TrendingNews) {
            binding.apply {
                newsIv.setImageResource(news.img)
                title.text = news.title
                timeTv.text = news.time
                categoryTv.text = news.category
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TrendingNewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size
}