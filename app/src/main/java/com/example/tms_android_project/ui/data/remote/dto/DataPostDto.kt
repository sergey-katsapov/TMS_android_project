package com.example.tms_android_project.ui.data.remote.dto

import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.domain.models.DomainPostList

data class DataPostDto(
    val id: Int,
    val title: String? = null,
    val description: String? = null
)

fun DataPostDto.toDomainPost() =
    DomainPost(
        id = id,
        title = title,
        description = description
    )

fun List<DataPostDto>.toDomainPostList() =
    DomainPostList(
        this.map {
            it.toDomainPost()
        }
    )