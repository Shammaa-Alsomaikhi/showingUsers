package com.abc.howingusers.Domain

import com.abc.howingusers.Domain.status.ERROR
import com.abc.howingusers.Domain.status.LOADING
import com.abc.howingusers.Domain.status.SUCCESS


data class Resource <out T>(val status: status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status = LOADING, data = data, message = null)
    }
}