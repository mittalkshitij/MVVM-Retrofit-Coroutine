package com.example.mvvmretrofitcoroutineexample.data.repository

import com.example.mvvmretrofitcoroutineexample.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}