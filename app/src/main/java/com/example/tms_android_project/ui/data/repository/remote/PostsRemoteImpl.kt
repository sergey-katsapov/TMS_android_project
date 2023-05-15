package com.example.tms_android_project.ui.data.repository.remote

import com.example.tms_android_project.ui.data.remote.api.PostsApi
import com.example.tms_android_project.ui.data.remote.dto.ResponseDto
import javax.inject.Inject

class PostsRemoteImpl @Inject constructor(
    private val postsApi: PostsApi
) : PostsRemote {

    override suspend fun getPosts(): ResponseDto =
        postsApi.getLatestNews()
}