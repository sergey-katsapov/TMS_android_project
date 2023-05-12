package com.example.tms_android_project.ui.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_android_project.ui.domain.models.DomainPostList
import com.example.tms_android_project.ui.domain.use_cases.PostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//DO-11
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val postsUseCase: PostsUseCase
) : ViewModel() {

    private val _postList = MutableLiveData<DomainPostList>()
    val postList: LiveData<DomainPostList> = _postList

    init {
        getPosts()
    }

    private fun getPosts() {
        //DO-12
        _postList.value = postsUseCase.getPosts()
    }
}