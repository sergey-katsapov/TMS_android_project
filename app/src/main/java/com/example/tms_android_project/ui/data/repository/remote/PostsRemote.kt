package com.example.tms_android_project.ui.data.repository.remote

import com.example.tms_android_project.ui.data.remote.dto.ResponseDto

interface PostsRemote {
     suspend fun getPosts() : ResponseDto
}