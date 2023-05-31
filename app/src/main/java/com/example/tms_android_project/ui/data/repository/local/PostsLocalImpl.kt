package com.example.tms_android_project.ui.data.repository.local

import com.example.tms_android_project.ui.data.local.PostEntity
import com.example.tms_android_project.ui.data.local.PostsDao
import javax.inject.Inject


class PostsLocalImpl@Inject constructor(
    private val postsDao: PostsDao
) : PostsLocal {

    override suspend fun getLocalPosts(): List<PostEntity>? = postsDao.getAll()

    override suspend fun insertPost(postEntity: PostEntity) {
        postsDao.insert(postEntity = postEntity)
    }

    override suspend fun deletePost(postEntity: PostEntity) {
        postsDao.delete(postEntity = postEntity)
    }

    override suspend fun updatePost(postEntity: PostEntity) {
        postsDao.update(postEntity = postEntity)
    }
}