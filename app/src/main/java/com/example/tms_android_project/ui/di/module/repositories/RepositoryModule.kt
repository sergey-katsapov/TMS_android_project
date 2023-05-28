package com.example.tms_android_project.ui.di.module.repositories

import com.example.tms_android_project.ui.data.repository.PostsRepositoryImpl
import com.example.tms_android_project.ui.data.repository.local.PostsLocal
import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providePostsRepository(
        postsRemote: PostsRemote,
        postsLocal: PostsLocal
    ): PostRepository =
        PostsRepositoryImpl(
            postsRemote = postsRemote,
            postsLocal = postsLocal
        )
}
