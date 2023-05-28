package com.example.tms_android_project.ui.di.module.repositories

import com.example.tms_android_project.ui.data.local.PostsDao
import com.example.tms_android_project.ui.data.repository.local.PostsLocal
import com.example.tms_android_project.ui.data.repository.local.PostsLocalImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalRepositoryModule {

    @Provides
    fun providePostsLocal(postsDao: PostsDao): PostsLocal =
        PostsLocalImpl(postsDao = postsDao)
}