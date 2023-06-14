package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.PostFragmentBinding
import com.example.tms_android_project.ui.di.base.DaggerDaggerComponent
import com.example.tms_android_project.ui.di.module.ViewModelFactory
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.presentation.view_models.AboutNewViewModel
import com.example.tms_android_project.ui.presentation.view_models.NewsViewModel
import java.lang.IllegalStateException
import javax.inject.Inject

class AboutNewFragment : Fragment() {

    private lateinit var binding: PostFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _viewModel: AboutNewViewModel? = null
    private val viewModel: AboutNewViewModel
        get() = _viewModel ?: throw IllegalStateException("Нет вью модели")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.application?.let { DaggerDaggerComponent.factory().create(it).inject(this) }
        _viewModel = viewModelFactory.create(AboutNewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        val postInfo = viewModel.postInfo.value ?: DomainPost()

        binding.apply {
            postTitle.text = postInfo.title
            postDescription.text = postInfo.description
        }
    }
}