package com.example.tms_android_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isLoginButtonEnabled()
    }

    private fun isLoginButtonEnabled() {
        binding.passwordEditText.doAfterTextChanged { password ->
            password?.length?.let {
                if (password.length >= 8) {
                    binding.buttonLogin.apply {
                        isEnabled = true
                        setOnClickListener {
                            findNavController().navigate(R.id.action_LoginFragment_to_NewsFragment)
                        }
                    }
                } else {
                    binding.buttonLogin.apply {
                        isEnabled = false
                    }
                }
            }
        }
    }
}