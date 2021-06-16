package com.abc.howingusers.Data.api



import com.abc.howingusers.Data.model.users
import retrofit2.http.GET


interface ApiService {

    @GET("/users/1")
    suspend fun getUsers(): List<users>


}