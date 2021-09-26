package com.orgustine.hagglex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.orgustine.hagglex.R
import com.orgustine.hagglex.ViewPagerAdapter
import com.orgustine.hagglex.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        var list = arrayListOf(R.drawable.pager4, R.drawable.pager3, R.drawable.pager2)
        val mAdapter = ViewPagerAdapter(list)
        binding.homeVp.adapter = mAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    mutation Register($data:CreateUserInput){
//        register(data:$data) {
//            user {
//                _id
//                username
//                email
//                phonenumber
//                phoneNumberDetails {
//                    phoneNumber
//                    callingCode
//                    flag
//                }
//                username
//                active
//                profile {
//                    displayName
//                }
//            }
//            token
//        }
//    }

}