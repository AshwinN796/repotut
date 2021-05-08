package com.repoenerytut.repotut.data.remote.factory

import okio.IOException
import retrofit2.HttpException

internal const val UNKNOWN_ERROR_RESPONSE_CODE = 520

internal fun HttpException.extractFromHttpException(): NetworkResponse.Error {
    val error = response()?.errorBody()
    val responseCode = response()?.code() ?: UNKNOWN_ERROR_RESPONSE_CODE
    val errorBody = when {
        error == null -> null // No error content available
        error.contentLength() == 0L -> null // Error content is empty
        else -> try {
            // There is error content present, so we should try to extract it
//            val typeA: Type = Types.newParameterizedType(
//                ErrorBody::class.java
//            )
//            val adapter: JsonAdapter<ErrorBody> = Moshi.Builder().build().adapter(typeA)
//            val event: ErrorBody? = adapter.fromJson(error.charStream().toString())
//            event
            return NetworkResponse.Error(
                code = responseCode,
                type = NetworkResponse.ErrorType.SERVER,
                error = null
            )
        } catch (e: Exception) {
            // If unable to extract content, return with a null body and don't parse further
            return NetworkResponse.Error(
                code = responseCode,
                type = NetworkResponse.ErrorType.SERVER,
                error = null
            )
        }
    }
    return NetworkResponse.Error(
        body = errorBody,
        code = responseCode,
        type = NetworkResponse.ErrorType.SERVER,
        error = null
    )
}

internal fun <S : Any> Throwable.extractNetworkResponse(): NetworkResponse<S> {
    return when (this) {
        is IOException -> NetworkResponse.Error(
            code = 0,
            type = NetworkResponse.ErrorType.NETWORK,
            error = this
        )
        is HttpException -> extractFromHttpException()
        else -> NetworkResponse.Error(
            code = 0,
            type = NetworkResponse.ErrorType.UNKNOWN,
            error = this
        )
    }
}