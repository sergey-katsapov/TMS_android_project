package com.example.tms_android_project.ui.di.module

import com.example.tms_android_project.ui.domain.repositories.PostRepository
import com.example.tms_android_project.ui.domain.use_cases.GetPostInfoUseCase
import com.example.tms_android_project.ui.domain.use_cases.PostsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {
    @Provides
    fun providePostInfoUseCase(postRepository: PostRepository) =
        GetPostInfoUseCase(postRepository = postRepository)
}
