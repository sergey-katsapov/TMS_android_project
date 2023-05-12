package com.example.tms_android_project.ui.domain.use_cases

import com.example.tms_android_project.ui.data.remote.dto.toDomainPost
import com.example.tms_android_project.ui.data.repository.PostsRepositoryImpl

class GetPostInfoUseCase {
    fun getPostInfo() = PostsRepositoryImpl().getPostInfo().toDomainPost()
}