package com.orgustine.hagglex.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.orgustine.hagglex.R
import com.orgustine.hagglex.databinding.FragmentDashboardBinding
import com.orgustine.hagglex.databinding.FragmentSignupBinding

class SignupFragment : Fragment(R.layout.fragment_signup) {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSignupBinding.bind(view)

        binding.signUpBtn.setOnClickListener {
            findNavController().navigate(R.id.verifyFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}