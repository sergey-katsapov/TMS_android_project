package com.example.tms_android_project.ui.data

import com.example.tms_android_project.ui.data.models.PostModel

open class BaseData {

    open fun elements(): List<PostModel> {
        val posts = mutableListOf(
            PostModel(
                id = 1,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 2,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 3,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 4,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 5,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 6,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 7,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 8,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 9,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 10,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 11,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 12,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 13,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 14,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 15,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 16,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 17,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 18,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 19,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 20,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 21,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 22,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 23,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 24,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            PostModel(
                id = 25,
                title = "Test Post Title",
                description = "Test Post Description"
            )
        )

        return posts
    }
}