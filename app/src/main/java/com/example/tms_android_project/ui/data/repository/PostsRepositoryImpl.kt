package com.example.tms_android_project.ui.data.repository

import com.example.tms_android_project.ui.data.local.Post
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
        val postList = postsRemote.getPosts().posts.orEmpty()
        if (postList.isNotEmpty()) {
            postList.forEach { postDto ->
                postsLocal.insertPost(post = postDto.toLocalPost())
            }
        }
        return postList
    }

    override suspend fun getLocalPosts(): List<Post> = postsLocal.getLocalPosts().orEmpty()
}