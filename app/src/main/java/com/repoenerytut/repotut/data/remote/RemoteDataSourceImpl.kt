package com.repoenerytut.repotut.data.remote

import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
class RemoteDataSourceImpl(private val restService: RestService): RemoteDataSource {
    override suspend fun getNewsTopHeadlines(): NetworkResponse<NewsHeadingResponse> {
        return restService.getNewsTopHeadlines()
    }
}