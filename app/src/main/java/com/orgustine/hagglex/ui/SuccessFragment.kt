package com.orgustine.hagglex.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.orgustine.apollo.RegisterMutation
import com.orgustine.apollo.type.CreateUserInput
import com.orgustine.apollo.type.PhoneNumberDetailsInput
import com.orgustine.hagglex.R
import com.orgustine.hagglex.databinding.FragmentSignupBinding
import com.orgustine.hagglex.databinding.FragmentSuccesBinding
import com.orgustine.hagglex.network.Apollo
import com.orgustine.hagglex.util.AuthStore


class SuccessFragment : Fragment(R.layout.fragment_succes) {
    private var _binding: FragmentSuccesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSuccesBinding.bind(view)

        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.dashboardFragment)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}