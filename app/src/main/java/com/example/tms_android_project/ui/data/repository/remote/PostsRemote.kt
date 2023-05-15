package com.example.tms_android_project.ui.data.repository.remote

import com.example.tms_android_project.ui.data.remote.dto.DataPostDto
import com.example.tms_android_project.ui.data.remote.dto.UserList
import retrofit2.Call
import retrofit2.Response

interface PostsRemote {
     fun getPosts(): List<DataPostDto>
     fun getPostInfo(): DataPostDto

     fun doGetUserList() : Call<UserList?>?
}