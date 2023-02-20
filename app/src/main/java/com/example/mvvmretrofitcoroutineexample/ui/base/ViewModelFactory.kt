package com.example.mvvmretrofitcoroutineexample.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitcoroutineexample.data.api.ApiHelper
import com.example.mvvmretrofitcoroutineexample.data.repository.MainRepository
import com.example.mvvmretrofitcoroutineexample.ui.main.viewmodel.MainViewModel


class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}