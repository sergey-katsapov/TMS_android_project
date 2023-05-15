package com.example.tms_android_project.ui.domain.repositories

import com.example.tms_android_project.ui.data.remote.dto.DataPostDto
import com.example.tms_android_project.ui.data.remote.dto.UserList

interface PostRepository {
     fun getPosts(): List<DataPostDto>
     fun getPostInfo(): DataPostDto

     fun getUsers()
}