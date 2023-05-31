package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tms_android_project.databinding.TestBindingFragmentBinding
import com.example.tms_android_project.ui.domain.models.DomainPost
import dagger.hilt.android.AndroidEntryPoint

//DO-9
@AndroidEntryPoint
class TestBindingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = TestBindingFragmentBinding.inflate(inflater, container, false)
        //DO-10
//        .also {
//            it.post = postInfo
//        }
        binding.post = postInfo
        return binding.root
    }

    private companion object {
        val postInfo = DomainPost(
            title = "Binding test title",
            description = "Binding test description",
            url = "Binding test url",
            urlToImage = "Binding test urlToImage",
            publishedAt = "Binding test publishedAt"
        )
    }
}