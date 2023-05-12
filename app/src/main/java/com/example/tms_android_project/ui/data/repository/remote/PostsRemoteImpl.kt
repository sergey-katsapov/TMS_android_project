package com.example.tms_android_project.ui.data.repository.remote

import com.example.tms_android_project.ui.data.remote.dto.DataPostDto

class PostsRemoteImpl() : PostsRemote {

    override fun getPosts(): List<DataPostDto> =
        mutableListOf(
            DataPostDto(
                id = 1,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 2,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 3,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 4,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 5,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 6,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 7,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 8,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 9,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 10,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 11,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 12,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 13,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 14,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 15,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 16,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 17,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 18,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 19,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 20,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 21,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 22,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 23,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 24,
                title = "Test Post Title",
                description = "Test Post Description"
            ),
            DataPostDto(
                id = 25,
                title = "Test Post Title",
                description = "Test Post Description"
            )
        )

    override fun getPostInfo(): DataPostDto =
            DataPostDto(
                id = 1,
                title = "French dog",
                description = "The one-of-a-kind French Bulldog, with his large bat ears and even disposition, is one of the world's most popular small-dog breeds, especially among city dwellers. The Frenchie is playful, alert, adaptable, and completely irresistible. The French Bulldog resembles a Bulldog in miniature, except for the large, erect 'bat ears'\u009D that are the breed's trademark feature. The head is large and square, with heavy wrinkles rolled above the extremely short nose. The body beneath the smooth, brilliant coat is compact and muscular. The bright, affectionate Frenchie is a charmer. Dogs of few words, Frenchies don't bark much'¿but their alertness makes them excellent watchdogs. They happily adapt to life with singles, couples, or families, and do not require a lot of outdoor exercise. They get on well with other animals and enjoy making new friends of the human variety. It is no wonder that city folk from Paris to Peoria swear by this vastly amusing and companionable breed."
            )
}