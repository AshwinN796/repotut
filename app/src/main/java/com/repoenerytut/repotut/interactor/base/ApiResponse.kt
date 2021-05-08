package com.repoenerytut.repotut.interactor.base

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
data class ApiResponse<T : Any>(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val `data`: T? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Boolean? = null
)