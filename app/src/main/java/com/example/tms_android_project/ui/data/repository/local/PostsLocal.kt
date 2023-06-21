package com.example.tms_android_project.ui.data.repository.local

import com.example.tms_android_project.ui.data.local.PostEntity

interface PostsLocal {
     suspend fun getLocalPosts(): List<PostEntity>?
     suspend fun insertPost(postEntity: PostEntity)
     suspend fun deletePost(postEntity: PostEntity)
     suspend fun updatePost(postEntity: PostEntity)
}