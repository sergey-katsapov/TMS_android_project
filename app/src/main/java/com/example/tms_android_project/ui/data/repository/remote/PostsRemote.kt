package com.example.tms_android_project.ui.data.repository.remote

import com.example.tms_android_project.ui.data.remote.dto.DataPostDto

interface PostsRemote {
     fun getPosts(): List<DataPostDto>
}