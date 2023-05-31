package com.example.tms_android_project.ui.data.repository

import com.example.tms_android_project.ui.data.local.PostEntity
import com.example.tms_android_project.ui.data.remote.dto.PostDto
import com.example.tms_android_project.ui.data.remote.dto.toLocalPost
import com.example.tms_android_project.ui.data.repository.local.PostsLocal
import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsRepositoryImpl @Inject constructor(
    private val postsRemote: PostsRemote,
    private val postsLocal: PostsLocal
) : PostRepository {
    override suspend fun getPosts(): List<PostDto> {
        //список подгруженный с сервера
        val postList = postsRemote.getPosts().posts.orEmpty()

        //проход по этому списку и добавление в базу данных
        if (postList.isNotEmpty()) {
            postList.forEach { postDto ->
                postsLocal.insertPost(postEntity = postDto.toLocalPost())
            }
        }

        //вовзрат списка как и раньше в use case
        return postList
    }


    override suspend fun getLocalPosts(): List<PostEntity> = postsLocal.getLocalPosts().orEmpty()
    override suspend fun getPostInfoFromLocal(): PostEntity? {
        return null//TODO add logic get from database
    }
}