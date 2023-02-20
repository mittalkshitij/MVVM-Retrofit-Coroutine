package com.example.mvvmretrofitcoroutineexample.data.api

import com.example.mvvmretrofitcoroutineexample.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers() : List<User>
}