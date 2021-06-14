package com.abc.howingusers.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abc.howingusers.Data.users

class MainViewModel : ViewModel() {
        var lst = MutableLiveData<ArrayList<users>>()
        var newlist = arrayListOf<users>()

        fun add(user: users){
            newlist.add(user)
            lst.value=newlist
        }



}