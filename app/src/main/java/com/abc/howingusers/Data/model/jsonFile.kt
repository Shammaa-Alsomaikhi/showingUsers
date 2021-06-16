package com.abc.howingusers.Data.model

import com.google.gson.annotations.SerializedName

class jsonFile (
    @SerializedName("page")
    val page:String,

    @SerializedName("per_page")
    val per_page:String,

    @SerializedName("total")
    val total:String,

    @SerializedName("total_pages")
    val total_pages:String,

    @SerializedName("data")
    val  userList:List<users>
        ) {

}