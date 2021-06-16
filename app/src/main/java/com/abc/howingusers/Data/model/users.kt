package com.abc.howingusers.Data.model

import com.google.gson.annotations.SerializedName


data class users(
   @SerializedName("id")
    val userID: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
   val first_name: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("avatar")
    val avatar: String) {

}