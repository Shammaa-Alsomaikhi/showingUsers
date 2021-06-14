package com.abc.howingusers.Data

data class users(val userID: Int, val email: String, val firstName: String, val lastName: String, val avatar: String) {

    override fun toString(): String {
        return " ID: $userID " +
                "| email: $email " +
                "| name: $firstName  $lastName" +
                "| avatar: $avatar"
    }
}