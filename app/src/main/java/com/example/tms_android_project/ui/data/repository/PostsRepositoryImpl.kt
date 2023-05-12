package com.example.tms_android_project.ui.data.repository

import com.example.tms_android_project.ui.data.remote.dto.DataPostDto
import com.example.tms_android_project.ui.data.repository.remote.PostsRemoteImpl
import com.example.tms_android_project.ui.domain.repositories.PostRepository

class PostsRepositoryImpl : PostRepository {
    override fun getPosts(): List<DataPostDto> = PostsRemoteImpl().getPosts()
    override fun getPostInfo(): DataPostDto = PostsRemoteImpl().getPostInfo()
}