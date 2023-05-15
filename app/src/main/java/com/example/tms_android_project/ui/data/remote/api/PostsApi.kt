package com.example.tms_android_project.ui.data.remote.api

import com.example.tms_android_project.ui.data.remote.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query


interface PostsApi {
    companion object {
        const val GET_POSTS_REQUEST = "top-headlines"

        const val SOURCE_PARAM = "sources"
        const val KEY_PARAM = "apiKey"

        const val API_KEY = "79e587936f2646a58099a6fb18cd29eb"
        const val SOURCE_CONST = "techcrunch"
    }

    @GET(GET_POSTS_REQUEST)
    suspend fun getLatestNews(
        @Query(SOURCE_PARAM) source: String = SOURCE_CONST,
        @Query(KEY_PARAM) apiKey: String = API_KEY
    ): ResponseDto
}