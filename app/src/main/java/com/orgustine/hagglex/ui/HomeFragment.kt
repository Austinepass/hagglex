package com.orgustine.hagglex.ui

import com.orgustine.hagglex.data.MarketAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.orgustine.hagglex.*
import com.orgustine.hagglex.data.DoMoreAdapter
import com.orgustine.hagglex.data.TrendingAdapter
import com.orgustine.hagglex.data.ViewPagerAdapter
import com.orgustine.hagglex.databinding.FragmentHomeBinding
import com.orgustine.hagglex.util.DummyData.doMoreList
import com.orgustine.hagglex.util.DummyData.marketList
import com.orgustine.hagglex.util.DummyData.newsList
import com.orgustine.hagglex.util.DummyData.vplist

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        setupView()
    }

    fun setupView(){

        binding.homeVp.adapter =
            ViewPagerAdapter(vplist)
        binding.marketList.apply {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = MarketAdapter(marketList)
        }

        binding.doMoreList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = DoMoreAdapter(doMoreList)
        }

        binding.newsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = TrendingAdapter(newsList)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}