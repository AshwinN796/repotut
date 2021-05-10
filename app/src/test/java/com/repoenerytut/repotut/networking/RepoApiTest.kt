package com.repoenerytut.repotut.networking

import com.repoenerytut.repotut.data.remote.RestService
import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.data.remote.factory.NetworkResponseAdapterFactory
import com.repoenerytut.repotut.data.remote.factory.StringConverterFactory
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by Ashwin Nirmale on 10/05/21.
 */

@ExperimentalCoroutinesApi
class RepoApiTest {

    private lateinit var server: MockWebServer
    private lateinit var executor: ExecutorService
    private lateinit var retrofit: Retrofit
    private lateinit var service: RestService

    @Before
    fun createService() {
        server = MockWebServer()
        executor = Executors.newSingleThreadExecutor()
        retrofit = Retrofit.Builder()
            .baseUrl(server.url("/suspend/"))
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(StringConverterFactory())
            .callbackExecutor(executor)
            .build()

        service = retrofit.create(RestService::class.java)
    }

    @After
    fun stopService() {
        server.shutdown()
    }

    @Test
    fun `success response test`() {
        val responseBody = parseResponseFromFile("newHeadingResponse")
        enqueueResponse(responseBody)

        val response = runBlocking {
            service.getNewsTopHeadlines()
        }

        with(response) {
            shouldBeTypeOf<NetworkResponse.Success<String>> {
                this as NetworkResponse.Success
                body shouldBe responseBody
            }
        }
    }

    private fun enqueueResponse(responseBody: String) {
        server.enqueue(
            MockResponse()
                .setBody(responseBody)
                .setResponseCode(200)
                .setHeader("TEST","test")
        )
    }


    private fun parseResponseFromFile(fileName: String, headers: Map<String, String> = emptyMap()): String {
        val inputStream = javaClass.classLoader!!.getResourceAsStream("apiResponse/${fileName}.json")
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        return source.readString(Charsets.UTF_8)
    }

}