package com.example.tms_android_project.ui.data.repository

import com.example.tms_android_project.ui.data.remote.dto.DataPostDto
import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

//DO-8
@Singleton
class PostsRepositoryImpl @Inject constructor(
    private val postsRemote: PostsRemote
) : PostRepository {
    override fun getPosts(): List<DataPostDto> = postsRemote.getPosts()
    override fun getPostInfo(): DataPostDto = postsRemote.getPostInfo()
}