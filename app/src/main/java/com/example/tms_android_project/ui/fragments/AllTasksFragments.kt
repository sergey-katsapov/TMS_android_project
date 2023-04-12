package com.example.tms_android_project.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.FragmentAllTasksBinding

class AllTasksFragments : Fragment() {

    private lateinit var binding: FragmentAllTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllTasksBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirstTask.setOnClickListener {
            findNavController().navigate(R.id.action_AllTasksFragment_to_LoginFragment)
        }
    }
}