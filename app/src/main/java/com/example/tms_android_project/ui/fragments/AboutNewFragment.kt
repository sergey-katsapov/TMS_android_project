package com.example.tms_android_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tms_android_project.databinding.FragmentAboutNewBinding
import com.example.tms_android_project.databinding.FragmentNewsBinding


class AboutNewFragment : Fragment() {

    private lateinit var binding: FragmentAboutNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutNewBinding.inflate(inflater, container, false);
        return binding.root
    }
}