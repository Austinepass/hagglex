package com.orgustine.hagglex.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orgustine.hagglex.data.mdel.Market
import com.orgustine.hagglex.databinding.MarketItemLayoutBinding

class MarketAdapter(private val list: List<Market>) : RecyclerView.Adapter<MarketAdapter.ViewHolder>() {

     class ViewHolder(private val binding: MarketItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
             fun bind(market: Market) {
             binding.apply {
                 coinLogo.setImageResource(market.img)
                 coinName.text = market.title
                 nairaValue.text = market.naira
                 percentChange.text = market.increment
                 chart.setImageResource(market.chart)
             }
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MarketItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size
}