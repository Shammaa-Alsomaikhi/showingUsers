package com.abc.howingusers.UI.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abc.howingusers.Data.api.ApiHelper
import com.abc.howingusers.UI.main.viewmodel.mainViewModel
import com.abc.howingusers.Data.repository.mainRepository



class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(mainViewModel::class.java)) {
            return mainViewModel(mainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}