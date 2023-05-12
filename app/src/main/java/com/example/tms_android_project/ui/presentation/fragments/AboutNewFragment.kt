package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.PostFragmentBinding
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.presentation.view_models.AboutNewViewModel

class AboutNewFragment : Fragment() {

    private lateinit var binding: PostFragmentBinding
    private var viewModel: AboutNewViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(owner = this)[AboutNewViewModel::class.java]
        binding = PostFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        initToolbar()
        initRecycler()
    }

    private fun initToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(resId = R.id.action_AboutNewFragment_to_NewsFragment)
        }
    }

    private fun initRecycler() {
        val postInfo = viewModel?.postInfo?.value ?: DomainPost()

        binding.apply {
            postTitle.text = postInfo.title
            postDescription.text = postInfo.description
        }
    }
}