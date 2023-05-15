package com.example.tms_android_project.ui.domain.use_cases

import com.example.tms_android_project.ui.data.remote.dto.toDomainPost
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun getPosts() : List<DomainPost> = postRepository.getPosts().map { postDto ->
        postDto.toDomainPost()
    }
}