package com.abc.howingusers.Data.api

class ApiHelper (private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}