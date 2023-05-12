package com.example.tms_android_project.ui.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_android_project.ui.domain.models.DomainPostList
import com.example.tms_android_project.ui.domain.use_cases.PostsUseCase

open class NewsViewModel : ViewModel() {

    private val _postList = MutableLiveData<DomainPostList>()
    val postList: LiveData<DomainPostList> = _postList

    init {
        getPosts()
    }

    private fun getPosts() {
        _postList.value = PostsUseCase().getPosts()
    }
}