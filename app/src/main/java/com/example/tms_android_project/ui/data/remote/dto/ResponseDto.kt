package com.example.tms_android_project.ui.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseDto (
    @SerializedName("totalResults")
    val totalResults : Int,

    @SerializedName("articles")
    val posts : List<PostDto>?
)