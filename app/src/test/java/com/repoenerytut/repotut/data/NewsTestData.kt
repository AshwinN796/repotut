package com.repoenerytut.repotut.data

import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.interactor.response.NewsHeadingItem
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse

/**
 * Created by Ashwin Nirmale on 10/05/21.
 */
object NewsTestData {

    val newHead1 = NewsHeadingItem(
        source = null,
        author = "Hello",
        url = "www.htttp.com",
        urlToImage = "www.urltoimag.com/image.jpg",
        description = "Ok",
        title = "Good",
        publishedAt = "12134685161"
    )

    val newHead2 = NewsHeadingItem(
        source = null,
        author = "Hello",
        url = "www.htttp.com",
        urlToImage = "www.urltoimag.com/image.jpg",
        description = "Ok",
        title = "Good",
        publishedAt = "12134685161"
    )

    private val newsList = listOf(newHead1, newHead2)

    private val newsResponseSuccess = NewsHeadingResponse(
        status = true,
        totalResults = 2,
        articles = newsList
    )

    val apiResponse = NetworkResponse.Success(newsResponseSuccess)

    private val newsResponseError = NewsHeadingResponse(
        status = false,
        totalResults = 2,
        articles = null
    )

    val apiResponseError = NetworkResponse.Success(newsResponseError)

}