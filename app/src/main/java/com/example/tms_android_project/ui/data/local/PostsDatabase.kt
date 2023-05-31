package com.example.tms_android_project.ui.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PostEntity::class], version = 2)
abstract class PostsDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}