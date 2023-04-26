package com.example.tms_android_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.FirstFragmentBinding
import com.example.tms_android_project.databinding.FragmentLoginBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        binding.btnFirstClick.setOnClickListener {
            launchNextFragment()
        }
        return binding.root
    }


    private fun launchNextFragment() {
        val bundle = Bundle()

        bundle.putInt("TestArg", 1)

        val fragment = SecondFragment()
        fragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .add(R.id.main_fragment_container, fragment)
            .commit()
    }
}