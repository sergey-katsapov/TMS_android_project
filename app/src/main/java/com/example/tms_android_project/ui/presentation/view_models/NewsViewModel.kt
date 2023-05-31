package com.example.tms_android_project.ui.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.domain.use_cases.PostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
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
        Timber.tag("TAG_ANDROID").e("igor ne spi")

         _postList.value = postsUseCase.getPosts()
    }
}