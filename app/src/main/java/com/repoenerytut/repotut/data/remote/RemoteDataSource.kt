package com.repoenerytut.repotut.data.remote

import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.interactor.response.NewsHeadingItem
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
interface RemoteDataSource {
    suspend fun getNewsTopHeadlines(): NetworkResponse<NewsHeadingResponse>
}