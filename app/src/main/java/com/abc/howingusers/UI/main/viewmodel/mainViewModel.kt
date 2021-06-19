package com.abc.howingusers.UI.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.abc.howingusers.Data.repository.mainRepository
import com.abc.howingusers.Domain.Resource

import kotlinx.coroutines.Dispatchers

class mainViewModel (private val mainRepository: mainRepository) : ViewModel() {

     fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}