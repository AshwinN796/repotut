package com.repoenerytut.repotut.data.remote.factory

import com.repoenerytut.repotut.interactor.base.ApiResponse

sealed class NetworkResponse<out T : Any> {

    data class Loading(val start: Int = 0) : NetworkResponse<Nothing>()

    /**
     * A request that resulted in a response with a 2xx status code that has a body.
     */
    data class Success<T : Any>(
        val body: T?
    ) : NetworkResponse<T>()


    /**
     * A request that resulted in a response with a non-2xx status code.
     */
    data class Error(
        val body: ErrorBody? = null,
        val error: Throwable?,
        val code: Int,
        val type: ErrorType
    ) : NetworkResponse<Nothing>()

    enum class ErrorType {
        SERVER,
        NETWORK,
        UNKNOWN
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val NetworkResponse<*>.succeeded
    get() = this is NetworkResponse.Success

fun <T : Any> NetworkResponse<T>.successOr(fallback: T): T {
    return (this as? NetworkResponse.Success<*>)?.body as T? ?: fallback
}

fun <T : Any> NetworkResponse<ApiResponse<T>>.map(): NetworkResponse<T> {
    if (this is NetworkResponse.Success) {
        return if (this.body?.status!!) {
            NetworkResponse.Success(this.body.data)
        } else {
            NetworkResponse.Error(
                code = this.body.code!!,
                type = NetworkResponse.ErrorType.SERVER,
                error = Throwable(this.body.message)
            )
        }

    }
    return NetworkResponse.Error(
        code = 0,
        type = NetworkResponse.ErrorType.SERVER,
        error = Throwable()
    )
}

val <T : Any> NetworkResponse<T>.data: Any?
    get() = (this as? NetworkResponse.Success)?.body