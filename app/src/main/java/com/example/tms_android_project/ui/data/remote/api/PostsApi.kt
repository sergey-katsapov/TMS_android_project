package com.example.tms_android_project.ui.data.remote.api

import com.example.tms_android_project.ui.data.remote.dto.MultipleResource
import com.example.tms_android_project.ui.data.remote.dto.User
import com.example.tms_android_project.ui.data.remote.dto.UserList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface PostsApi {
    companion object {
        const val GET_POSTS_REQUEST = "тело_запроса"
        const val KEY_PARAM = "key_параметр"
    }

    //TODO suspend - объясню позже
    @GET("/api/unknown")
    open fun doGetListResources(): Call<MultipleResource?>?

    @POST("/api/users")
    fun createUser(@Body user: User?): Response<User?>?

    @GET("/api/users?")
    open fun doGetUserList(@Query("page") page: String?): Call<UserList?>?

    @FormUrlEncoded
    @POST("/api/users?")
    fun doCreateUserWithField(
        @Field("name") name: String?,
        @Field("job") job: String?
    ): Response<UserList?>?

}