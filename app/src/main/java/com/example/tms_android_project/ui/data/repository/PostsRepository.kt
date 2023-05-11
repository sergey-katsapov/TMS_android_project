package com.example.tms_android_project.ui.data.repository

import com.example.tms_android_project.ui.data.remote.dto.DataPostDto

interface PostsRepository {
    suspend fun getPosts(): List<DataPostDto>
}