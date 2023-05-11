package com.example.tms_android_project.ui.domain.use_cases

import com.example.tms_android_project.ui.data.remote.dto.toDomainPostList
import com.example.tms_android_project.ui.data.repository.PostsRepositoryImpl

class PostsUseCase {
    fun getPosts() = PostsRepositoryImpl().getPosts().toDomainPostList()
}