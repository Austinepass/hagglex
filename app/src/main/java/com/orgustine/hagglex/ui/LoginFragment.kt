package com.orgustine.hagglex.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.orgustine.apollo.LoginMutation
import com.orgustine.apollo.type.LoginInput
import com.orgustine.hagglex.R
import com.orgustine.hagglex.databinding.FragmentLoginBinding
import com.orgustine.hagglex.network.Apollo
import com.orgustine.hagglex.network.Apollo.apolloClient
import com.orgustine.hagglex.util.AuthStore

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        binding.loginBtn.setOnClickListener {
            //login()
            if (!validateInput()) findNavController().navigate(R.id.dashboardFragment)
        }

        binding.newUserTv.setOnClickListener {
            findNavController().navigate(R.id.signupFragment)
        }
    }

    fun login() {
        if (!validateInput()) {

            val userInput = LoginInput(
                binding.emailEt.text.toString().trim(),
                binding.passwordEt.text.toString().trim()
            )
            lifecycleScope.launchWhenResumed {
                val response = try {
                    apolloClient(requireContext()).mutate(LoginMutation(userInput)).await()
                } catch (e: Exception) {
                    Log.i("Login Resp", e.toString())
                    null
                }
                val login = response?.data?.login
                if (login == null || response.hasErrors()) {
                    Log.i("Login Resp", response.toString())
                    return@launchWhenResumed
                }
//            Apollo.apolloClient.mutate(LoginMutation(data = userInput)).enqueue(object :
//                ApolloCall.Callback<LoginMutation.Data>() {
//                override fun onResponse(response: Response<LoginMutation.Data>) {
//                    Log.i("Login Resp", response.toString())
//                    AuthStore.setToken(requireContext(), response.data!!.login.token!!)
//                    findNavController().navigate(R.id.dashboardFragment)
//                    findNavController().popBackStack()
//                }
//
//                override fun onFailure(e: ApolloException) {
//                    Log.i("Login ERR", e.toString())
//                }
//            })
        }}
    }

    private fun validateInput(): Boolean {
        var failFlag = false
        if (binding.emailEt.text.toString().trim().isEmpty()) {
            failFlag = true;
            binding.emailEt.error = "Invalid code";
        }
        return failFlag
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}