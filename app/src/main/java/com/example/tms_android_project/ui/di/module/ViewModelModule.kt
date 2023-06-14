package com.example.tms_android_project.ui.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import com.example.tms_android_project.ui.domain.use_cases.GetPostInfoUseCase
import com.example.tms_android_project.ui.domain.use_cases.PostsUseCase
import com.example.tms_android_project.ui.presentation.view_models.AboutNewViewModel
import com.example.tms_android_project.ui.presentation.view_models.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    fun postListViewModel(viewModel: NewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutNewViewModel::class)
    fun aboutNewViewModel(viewModel: AboutNewViewModel): ViewModel
}
