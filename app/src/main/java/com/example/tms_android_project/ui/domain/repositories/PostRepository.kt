package com.example.tms_android_project.ui.domain.repositories

import com.example.tms_android_project.ui.data.local.PostEntity
import com.example.tms_android_project.ui.data.remote.dto.PostDto

interface PostRepository {
    suspend fun getPosts(): List<PostDto>
    suspend fun getLocalPosts(): List<PostEntity>
}