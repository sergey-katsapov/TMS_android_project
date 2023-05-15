package com.example.tms_android_project.ui.data.repository

import com.example.tms_android_project.ui.data.remote.dto.PostDto
import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PostsRepositoryImpl @Inject constructor(
    private val postsRemote: PostsRemote
) : PostRepository {
    override suspend fun getPosts(): List<PostDto> = postsRemote.getPosts().posts.orEmpty()

//        postsRemote.getPosts().enqueue(object :
//            Callback<ResponseDto?> {
//            override fun onResponse(
//                call: Call<ResponseDto?>,
//                response: Response<ResponseDto?>
//            ) {
//                response.body()?.let {
//                    movieLiveData.value = it.posts!!
//                    return
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseDto?>, t: Throwable) {
//                movieLiveData.value = emptyList()
//            }
//        })
}