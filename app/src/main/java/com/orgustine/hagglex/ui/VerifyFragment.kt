package com.orgustine.hagglex.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.orgustine.hagglex.R
import com.orgustine.hagglex.databinding.FragmentSignupBinding
import com.orgustine.hagglex.databinding.FragmentVerifyBinding

class VerifyFragment : Fragment(R.layout.fragment_verify) {
    private var _binding: FragmentVerifyBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVerifyBinding.bind(view)

        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.successFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}