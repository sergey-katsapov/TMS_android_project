package com.example.tms_android_project.ui.data.local

import androidx.room.*

@Dao
interface PostsDao {
//    @get:Query("SELECT * FROM post")
//    val all: List<Post>?

    @Query("SELECT * FROM post")
    suspend fun getAll(): List<Post>?

    @Query("SELECT * FROM post WHERE id = :id")
    suspend fun getById(id: Long): Post?

    @Insert
    suspend fun insert(post: Post?)

    @Update
    suspend fun update(post: Post?)

    @Delete
    suspend fun delete(post: Post?)
}