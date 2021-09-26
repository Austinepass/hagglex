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
import com.orgustine.apollo.VerifyMutation
import com.orgustine.apollo.type.VerifyUserInput
import com.orgustine.hagglex.R
import com.orgustine.hagglex.databinding.FragmentVerifyBinding
import com.orgustine.hagglex.network.Apollo
import com.orgustine.hagglex.util.AuthStore

class VerifyFragment : Fragment(R.layout.fragment_verify) {
    private var _binding: FragmentVerifyBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVerifyBinding.bind(view)

        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.successFragment)
            if (!validateInput()) {

                val userInput = Input.fromNullable(
                    VerifyUserInput(
                        binding.codeEt.text.toString().trim().toInt()
                    )
                )
                Apollo.apolloClient(requireContext()).mutate(VerifyMutation(data = userInput)).enqueue(object :
                    ApolloCall.Callback<VerifyMutation.Data>() {
                    override fun onResponse(response: Response<VerifyMutation.Data>) {
                        Log.i("Ver Resp", response.toString())
                        response.data!!.verifyUser!!.user.username
                        AuthStore.setToken(requireContext(), response.data!!.verifyUser!!.token)
                        findNavController().navigate(R.id.successFragment)
                        findNavController().popBackStack()
                    }

                    override fun onFailure(e: ApolloException) {
                        Log.i("Ver ERR", e.toString())
                    }
                })
            }
        }
    }

    private fun validateInput(): Boolean {
        var failFlag = false
        if (binding.codeEt.text.toString().trim().length < 6) {
            failFlag = true;
            binding.codeEt.error = "Invalid code";
        }
        return failFlag
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}