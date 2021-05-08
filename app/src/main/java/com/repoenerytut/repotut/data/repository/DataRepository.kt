package com.repoenerytut.repotut.data.repository

import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
interface DataRepository {
    suspend fun getNewsTopHeadlines(): NetworkResponse<NewsHeadingResponse>
}