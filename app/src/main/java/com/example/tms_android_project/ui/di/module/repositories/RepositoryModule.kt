package com.example.tms_android_project.ui.di.module.repositories

import com.example.tms_android_project.ui.data.repository.PostsRepositoryImpl
import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePostsRepository(postsRemote: PostsRemote): PostRepository =
        PostsRepositoryImpl(postsRemote = postsRemote)
}
