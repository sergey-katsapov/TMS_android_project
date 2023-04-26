package com.example.tms_android_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.FragmentNewsBinding
import com.example.tms_android_project.ui.adapters.RecyclerAdapter
import com.example.tms_android_project.ui.data.BaseData
import androidx.navigation.fragment.findNavController


class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        initRecycler()
    }

    private fun initRecycler() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RecyclerAdapter(
                items =  BaseData().elements(),
                onItemClickEvent = {
                    findNavController().navigate(R.id.action_NewsFragment_to_NewsInfoFragment)
                }
            )
        }
    }
}