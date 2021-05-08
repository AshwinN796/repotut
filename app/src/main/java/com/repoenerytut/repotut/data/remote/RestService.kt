package com.repoenerytut.repotut.data.remote

import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.interactor.response.NewsHeadingItem
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse
import retrofit2.http.GET

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
interface RestService {

    @GET("top-headlines?country=us&apiKey=4266912a3d3646ddac88e8c5c0da10bb")
    suspend fun getNewsTopHeadlines(): NetworkResponse<NewsHeadingResponse>


}