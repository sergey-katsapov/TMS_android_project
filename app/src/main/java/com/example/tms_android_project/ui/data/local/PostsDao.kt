package com.example.tms_android_project.ui.data.local

import androidx.room.*

@Dao
interface PostsDao {
//    @get:Query("SELECT * FROM post")
//    val all: List<Post>?

    @Query("SELECT * FROM postentity")
    suspend fun getAll(): List<PostEntity>?


    //Use for about new fragment with id = 3
    @Query("SELECT * FROM postentity WHERE id = :postId")
    suspend fun getById(postId: Long): PostEntity?

    @Insert
    suspend fun insert(postEntity: PostEntity?)

    @Update
    suspend fun update(postEntity: PostEntity?)

    @Delete
    suspend fun delete(postEntity: PostEntity?)
}