package com.repoenerytut.repotut.data

import com.repoenerytut.repotut.data.remote.RemoteDataSource
import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse

/**
 * Created by Ashwin Nirmale on 10/05/21.
 */
object TestRemoteDataSource: RemoteDataSource {
    override suspend fun getNewsTopHeadlines(): NetworkResponse<NewsHeadingResponse> = NewsTestData.apiResponse
}