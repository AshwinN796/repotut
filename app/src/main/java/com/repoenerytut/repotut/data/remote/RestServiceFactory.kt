package com.repoenerytut.repotut.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.repoenerytut.repotut.BuildConfig
import com.repoenerytut.repotut.data.remote.factory.NetworkResponseAdapterFactory
import com.repoenerytut.repotut.utilities.ApiConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
object RestServiceFactory {

    /**
     * makeRestService
     */
    fun makeRestService(): RestService {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor()
        )

        return makeUserService(okHttpClient, makeGson())
    }

    /**
     * makeUserService
     */
    private fun makeUserService(okHttpClient: OkHttpClient, gson: Gson): RestService {
        return Retrofit.Builder()
            .baseUrl(ApiConstant.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(RestService::class.java)
    }


    /**
     * makeOkHttpClient
     */
    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    private fun makeGson(): Gson {
        return GsonBuilder().serializeNulls().create()
    }

    /**
     * makeLoggingInterceptor
     */
    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }

}