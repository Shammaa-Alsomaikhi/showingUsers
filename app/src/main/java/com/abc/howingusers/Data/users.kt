package com.abc.howingusers.Data

data class users(val id: Int, val email: String, val firstName: String, val lastName: String, val avatar: String) {

    override fun toString(): String {
        return " ID: $id " +
                "| email: $email " +
                "| name: $firstName  $lastName" +
                "| avatar: $avatar"
    }
}