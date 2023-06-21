package com.example.tms_android_project.ui.presentation.fragments

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.registerReceiver
import androidx.core.view.ContentInfoCompat.Flags
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.NewsFragmentBinding
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.presentation.adapters.RecyclerAdapter
import com.example.tms_android_project.ui.presentation.custom.InternetChangeReceiver
import com.example.tms_android_project.ui.presentation.custom.ModeChangeReceiver
import com.example.tms_android_project.ui.presentation.view_models.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

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

        airplaneModeReceiver()
        internetModeReceiver()

        observePosts()
    }

    private fun airplaneModeReceiver(){
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also { intentFilter ->
            activity?.registerReceiver(ModeChangeReceiver(), intentFilter)
        }
    }

    private fun internetModeReceiver(){
        activity?.registerReceiver(InternetChangeReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
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