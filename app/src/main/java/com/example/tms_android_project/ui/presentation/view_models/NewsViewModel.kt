package com.example.tms_android_project.ui.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.domain.use_cases.PostsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val postsUseCase: PostsUseCase
) : ViewModel() {

    private val _postList = MutableLiveData<List<DomainPost>>()
    val postList: LiveData<List<DomainPost>> = _postList

    init {
        viewModelScope.launch {
            getPosts()
        }
    }

    private suspend fun getPosts() {
         _postList.value = postsUseCase.getPosts()
    }
}