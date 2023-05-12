package com.example.tms_android_project.ui.domain.use_cases

import com.example.tms_android_project.ui.data.remote.dto.toDomainPostList
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

//DO-10
@Singleton
class PostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    fun getPosts() = postRepository.getPosts().toDomainPostList()
}