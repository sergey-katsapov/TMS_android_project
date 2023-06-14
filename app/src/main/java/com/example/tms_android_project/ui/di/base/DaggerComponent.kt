package com.example.tms_android_project.ui.di.base

import android.app.Application
import com.example.tms_android_project.ui.di.module.UseCasesModule
import com.example.tms_android_project.ui.di.module.ViewModelModule
import com.example.tms_android_project.ui.di.module.repositories.RemoteRepositoryModule
import com.example.tms_android_project.ui.di.module.repositories.RepositoryModule
import com.example.tms_android_project.ui.presentation.fragments.AboutNewFragment
import com.example.tms_android_project.ui.presentation.fragments.NewsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApiModule::class,
    DataBaseModule::class,
    RemoteRepositoryModule::class,
    RepositoryModule::class,
    UseCasesModule::class,
    ViewModelModule::class
])
internal interface  DaggerComponent {

    fun inject(fragment: NewsFragment)

    fun inject(fragment: AboutNewFragment)


    //Пока сильно не заострять внимание!
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): DaggerComponent
    }

}