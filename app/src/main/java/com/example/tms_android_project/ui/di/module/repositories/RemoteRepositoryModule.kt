package com.example.tms_android_project.ui.di.module.repositories

import com.example.tms_android_project.ui.data.remote.api.PostsApi
import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.data.repository.remote.PostsRemoteImpl
import dagger.Module
import dagger.Provides

@Module
class RemoteRepositoryModule {

    @Provides
    fun providePostsRemote(postsApi: PostsApi): PostsRemote = PostsRemoteImpl(postsApi = postsApi)
}
