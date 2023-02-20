package com.example.mvvmretrofitcoroutineexample.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmretrofitcoroutineexample.data.repository.MainRepository
import com.example.mvvmretrofitcoroutineexample.utils.Resource
import kotlinx.coroutines.Dispatchers



class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        }catch (exception: Exception){
            emit(Resource.error(null,exception.message?: "Error Occurred!"))
            Log.d("mytag",exception.message.toString())
        }
    }

}