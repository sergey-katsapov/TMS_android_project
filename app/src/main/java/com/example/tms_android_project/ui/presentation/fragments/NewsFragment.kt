package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.NewsFragmentBinding
import com.example.tms_android_project.ui.domain.models.DomainPostList
import com.example.tms_android_project.ui.presentation.adapters.RecyclerAdapter
import com.example.tms_android_project.ui.presentation.view_models.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentBinding
//    private var viewModel: NewsViewModel? = null

    //DO - 1
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel = ViewModelProvider(owner = this)[NewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
    }

    private fun initRecycler() {
        //val posts = viewModel?.postList?.value ?: DomainPostList()
        val posts = viewModel.postList.value ?: DomainPostList()

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