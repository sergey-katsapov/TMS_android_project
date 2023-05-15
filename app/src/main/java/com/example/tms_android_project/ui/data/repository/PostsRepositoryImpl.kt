package com.example.tms_android_project.ui.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tms_android_project.ui.data.remote.dto.DataPostDto
import com.example.tms_android_project.ui.data.remote.dto.UserList
import com.example.tms_android_project.ui.data.repository.remote.PostsRemote
import com.example.tms_android_project.ui.domain.repositories.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PostsRepositoryImpl @Inject constructor(
    private val postsRemote: PostsRemote
) : PostRepository {

    private val volumesResponseLiveData: MutableLiveData<UserList>? = null

    override fun getPosts(): List<DataPostDto> = postsRemote.getPosts()
    override fun getPostInfo(): DataPostDto = postsRemote.getPostInfo()
    override fun getUsers() {
        postsRemote.doGetUserList()?.enqueue(object :
            Callback<UserList?> {

                override fun onResponse(
                    call: Call<UserList?>,
                    response: Response<UserList?>
                ) {
                    if (response.body() != null) {
                        Log.d("TEST_ANDROID", "success")
                        volumesResponseLiveData?.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<UserList?>, t: Throwable) {
                        volumesResponseLiveData?.postValue(UserList())
                }
            })
    }

    fun getVolumesResponseLiveData(): LiveData<UserList?>? {
        return volumesResponseLiveData
    }
}