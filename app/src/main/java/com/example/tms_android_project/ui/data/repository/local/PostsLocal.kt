package com.example.tms_android_project.ui.data.repository.local

import com.example.tms_android_project.ui.data.local.Post

interface PostsLocal {
     suspend fun getLocalPosts(): List<Post>?

     suspend fun insertPost(post: Post)

     suspend fun deletePost(post: Post)

     suspend fun updatePost(post: Post)
}