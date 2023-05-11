package com.example.tms_android_project.ui.domain.repositories

import com.example.tms_android_project.ui.data.remote.dto.DataPostDto

interface PostRepository {
     fun getPosts(): List<DataPostDto>
}