package com.orgustine.hagglex.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.orgustine.hagglex.R
import com.orgustine.hagglex.databinding.FragmentSignupBinding
import com.orgustine.hagglex.databinding.FragmentSuccesBinding


class SuccessFragment : Fragment(R.layout.fragment_succes) {
    private var _binding: FragmentSuccesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSuccesBinding.bind(view)

        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.dashboardFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}