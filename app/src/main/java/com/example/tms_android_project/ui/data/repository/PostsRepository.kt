package com.example.tms_android_project.ui.data.repository

import com.example.tms_android_project.ui.data.local.Post
import com.example.tms_android_project.ui.data.remote.dto.PostDto

interface PostsRepository {
    suspend fun getPosts() : List<PostDto>?
    suspend fun getLocalPosts() : List<Post>?
}