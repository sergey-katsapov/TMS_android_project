package com.example.tms_android_project.ui.di.module.repositories

import com.example.tms_android_project.ui.data.repository.PostsRepositoryImpl
import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    //DO-9
    @Provides
    fun providePostsRepository(postsRemote: PostsRemote): PostRepository =
        PostsRepositoryImpl(postsRemote = postsRemote)
}
