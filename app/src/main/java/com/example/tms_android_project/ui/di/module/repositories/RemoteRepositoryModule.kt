package com.example.tms_android_project.ui.di.module.repositories

import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.data.repository.remote.PostsRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//DO-7
@Module
@InstallIn(SingletonComponent::class)
class RemoteRepositoryModule {

    @Provides
    fun providePostsRemote(): PostsRemote = PostsRemoteImpl()
}
