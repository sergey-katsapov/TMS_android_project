package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.NewsFragmentBinding
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.presentation.adapters.RecyclerAdapter
import com.example.tms_android_project.ui.presentation.models.NewsScreenUiState
import com.example.tms_android_project.ui.presentation.utils.observeWithLifecycle
import com.example.tms_android_project.ui.presentation.view_models.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentBinding

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onObservePosts()
        //onObserveScreenStateTest()
        onObserveScreenState()
        onObserveEventState()
    }

    private fun onObserveEventState() {
        viewModel.getEventsStream().observeWithLifecycle(
            fragment = this@NewsFragment, action = ::handleEvent
        )
    }

//    private fun onObserveScreenStateTest() {
//        lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.getScreenStream().collect {
//                    handleScreenState(it)
//                }
//            }
//        }
//    }

    private fun onObserveScreenState() {
        viewModel.getScreenStream().observeWithLifecycle(
            fragment = this@NewsFragment,
            action = ::handleScreenState
        )
    }

    private fun onObservePosts() {
        viewModel.uploadPosts()
    }

    private fun handleEvent(event: NewsViewModel.Event) {
        when (event) {
            is NewsViewModel.Event.Default -> return
            is NewsViewModel.Event.InitRecycler -> {
                initRecycler(event.list)
            }
        }
    }

    private fun handleScreenState(screenUiState: NewsScreenUiState) {
        updateProgressState(isVisible = screenUiState.isProgressVisible)
    }

    private fun updateProgressState(isVisible: Boolean) {
        binding.progress.isVisible = isVisible
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