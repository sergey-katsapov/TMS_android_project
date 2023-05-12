package com.example.tms_android_project.ui.di.module

import com.example.tms_android_project.ui.domain.repositories.PostRepository
import com.example.tms_android_project.ui.domain.use_cases.GetPostInfoUseCase
import com.example.tms_android_project.ui.domain.use_cases.PostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {
    @Provides
    fun providePostInfoUseCase(postRepository: PostRepository) =
        GetPostInfoUseCase(postRepository = postRepository)

    @Provides
    fun providePostsUseCase(postRepository: PostRepository) =
        PostsUseCase(postRepository = postRepository)
}
