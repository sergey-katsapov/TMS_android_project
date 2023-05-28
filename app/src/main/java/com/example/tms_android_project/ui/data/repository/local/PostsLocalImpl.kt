package com.example.tms_android_project.ui.data.repository.local

import com.example.tms_android_project.ui.data.local.Post
import com.example.tms_android_project.ui.data.local.PostsDao
import javax.inject.Inject


class PostsLocalImpl@Inject constructor(
    private val postsDao: PostsDao
) : PostsLocal {

    override suspend fun getLocalPosts(): List<Post>? = postsDao.getAll()

    override suspend fun insertPost(post: Post) {
        postsDao.insert(post = post)
    }

    override suspend fun deletePost(post: Post) {
        postsDao.delete(post = post)
    }

    override suspend fun updatePost(post: Post) {
        postsDao.update(post = post)
    }
}