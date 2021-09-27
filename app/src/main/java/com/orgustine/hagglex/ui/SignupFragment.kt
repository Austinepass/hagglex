package com.orgustine.hagglex.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.hbb20.CountryCodePicker
import com.orgustine.apollo.RegisterMutation
import com.orgustine.apollo.type.CreateUserInput
import com.orgustine.apollo.type.PhoneNumberDetailsInput
import com.orgustine.hagglex.R
import com.orgustine.hagglex.databinding.FragmentSignupBinding
import com.orgustine.hagglex.network.Apollo.apolloClient
import com.orgustine.hagglex.util.AuthStore

class SignupFragment : Fragment(R.layout.fragment_signup) {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private lateinit var ccp: CountryCodePicker

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSignupBinding.bind(view)

        binding.tb.setOnClickListener {
            findNavController().popBackStack()
        }

        ccp = binding.ccp
        ccp.registerCarrierNumberEditText(binding.phoneEt)
        binding.signUpBtn.setOnClickListener {
            //signUp()
            if (!validateInput()) findNavController().navigate(R.id.verifyFragment)

        }
    }

    fun signUp () {
        val fullPhoneNumber = ccp.fullNumberWithPlus

        if (!validateInput()) {

            val userInput = Input.fromNullable(
                CreateUserInput(
                    binding.emailEt.text.toString(),
                    binding.usernameEt.text.toString(),
                    binding.passwordEt.text.toString(),
                    fullPhoneNumber,
                    Input.fromNullable(binding.referralEt.text.toString()),
                    Input.fromNullable(
                        PhoneNumberDetailsInput(
                            binding.phoneEt.text.toString(),
                            ccp.selectedCountryCodeWithPlus,
                            ccp.selectedCountryNameCode
                        )
                    ),
                    ccp.selectedCountryName,
                    ccp.selectedCountryNameCode

                )
            )
            lifecycleScope.launchWhenResumed {
                val response =  try {
                    apolloClient(requireContext()).mutate(RegisterMutation(data = userInput)).await()
                } catch (e: Exception) {
                    Log.i("Login Resp", e.toString())
                    null
                }
                val register = response?.data?.register
                if (register == null || response.hasErrors()) {
                    Log.i("Reg Err", response.toString())
                    return@launchWhenResumed
                } else {
                    Log.i("res", response.toString())
                    AuthStore.setToken(requireContext(), response.data!!.register!!.token)
                    findNavController().navigate(R.id.verifyFragment)
                }
            }

//                apolloClient(requireContext()).mutate(RegisterMutation(data = userInput)).enqueue(object :
//                    ApolloCall.Callback<RegisterMutation.Data>() {
//                    override fun onResponse(response: Response<RegisterMutation.Data>) {
//
//                        val register = response.data?.register
//                        if (register == null || response.hasErrors()) {
//                            Log.i("Reg Err", response.toString())
//                            //return
//                        } else {
//                            Log.i("res", response.toString())
//                            AuthStore.setToken(requireContext(), response.data!!.register!!.token)
//                            findNavController().navigate(R.id.verifyFragment)
//                            findNavController().popBackStack()
//                        }
//
//                    }
//
//                    override fun onFailure(e: ApolloException) {
//                        Log.i("ERR", e.toString())
//                    }
//                })
        }


    }


    private fun validateInput(): Boolean {
        var failFlag = false
        if (binding.emailEt.text.toString().trim().isEmpty()
            || !binding.emailEt.text.toString().trim().contains('@')
            || !binding.emailEt.text.toString().trim().contains('.')) {
            failFlag = true;
            binding.emailEt.error = "Invalid email";
        }
        if (binding.usernameEt.text.toString().trim().isEmpty()) {
            failFlag = true;
            binding.usernameEt.error = "Username must be 6 - 20 characters long!";
        }
        if (binding.passwordEt.text.toString().trim().length < 9) {
            failFlag = true;
            binding.passwordEt.error = "Password too weak";
        }
        if (binding.phoneEt.text.toString().trim().length < 10) {
            failFlag = true;
            binding.phoneEt.error = "Invalid phone number";
        }
        return failFlag

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}