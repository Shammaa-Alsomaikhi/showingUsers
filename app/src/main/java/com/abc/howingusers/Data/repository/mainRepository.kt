package com.abc.howingusers.Data.repository

import com.abc.howingusers.Data.api.ApiHelper

class mainRepository (private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}