package com.abc.howingusers.UI.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abc.howingusers.Data.api.ApiHelper
import com.abc.howingusers.UI.main.viewmodel.mainViewModel
import com.abc.howingusers.Data.repository.mainRepository



class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

/*
Implementations of ViewModelProviders.Factory interface are responsible to instantiate ViewModels.
That means you write your own implementation for creating an instance of ViewModel.
*/
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(mainViewModel::class.java)) {
            return mainViewModel(mainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}