package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.FragmentNewsBinding
import com.example.tms_android_project.ui.domain.models.DomainPostList
import com.example.tms_android_project.ui.presentation.adapters.RecyclerAdapter
import com.example.tms_android_project.ui.presentation.view_models.PostsViewModel

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private var viewModel: PostsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity()).get(PostsViewModel::class.java)
    }

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
       val posts =  viewModel?.postList?.value ?: DomainPostList() //TODO

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RecyclerAdapter(
                items = posts,
                onItemClickEvent = {
                    findNavController().navigate(R.id.action_NewsFragment_to_NewsInfoFragment)
                }
            )
        }
    }
}