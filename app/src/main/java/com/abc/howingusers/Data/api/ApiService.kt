package com.abc.howingusers.Data.api



import com.abc.howingusers.Data.model.jsonFile
import com.abc.howingusers.Data.model.users
import retrofit2.http.GET


interface ApiService {

    @GET("users")
    suspend fun getUsers(): jsonFile


}