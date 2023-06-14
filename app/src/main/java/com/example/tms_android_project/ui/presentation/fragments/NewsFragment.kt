package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.NewsFragmentBinding
import com.example.tms_android_project.ui.di.base.DaggerDaggerComponent
import com.example.tms_android_project.ui.di.module.ViewModelFactory
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.presentation.adapters.RecyclerAdapter
import com.example.tms_android_project.ui.presentation.view_models.NewsViewModel
import java.lang.IllegalStateException
import javax.inject.Inject

class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _viewModel: NewsViewModel? = null

    private val viewModel: NewsViewModel
        get() = _viewModel ?: throw IllegalStateException("Нет вью модели")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.application?.let { DaggerDaggerComponent.factory().create(it).inject(this) }
        _viewModel = viewModelFactory.create(NewsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observePosts()
    }

    private fun observePosts() {
        viewModel.postList.observe(viewLifecycleOwner) { posts ->
            initRecycler(posts)
        }
    }

    private fun initRecycler(posts: List<DomainPost>) {
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