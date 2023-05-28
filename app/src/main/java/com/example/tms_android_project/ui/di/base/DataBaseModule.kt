package com.example.tms_android_project.ui.di.base

import android.content.Context
import androidx.room.Room
import com.example.tms_android_project.ui.data.local.Post
import com.example.tms_android_project.ui.data.local.PostsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): PostsDatabase =
        Room.databaseBuilder(
            context, PostsDatabase::class.java,
            "posts_db"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDao(db: PostsDatabase) = db.postsDao()

    @Provides
    fun provideEntity() = Post()
}