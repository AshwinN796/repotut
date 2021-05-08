package com.repoenerytut.repotut.utilities

import com.repoenerytut.repotut.BuildConfig

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */

const val DEV = "dev"
const val STAGING = "staging"

class ApiConstant {

    companion object {
        val BASE_URL = when (BuildConfig.FLAVOR) {
            DEV -> "https://newsapi.org/v2/"
            STAGING -> "https://newsapi.org/v2/"
            else -> ""
        }
    }

}