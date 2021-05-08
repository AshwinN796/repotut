package com.repoenerytut.repotut.data.repository

import com.repoenerytut.repotut.data.coroutines.DispatcherProvider
import com.repoenerytut.repotut.data.remote.RemoteDataSource
import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
class DataRepositoryImpl(private val dispatcherProvider: DispatcherProvider,
                            private val remoteDataSource: RemoteDataSource): DataRepository {
    override suspend fun getNewsTopHeadlines(): NetworkResponse<NewsHeadingResponse> {
        return remoteDataSource.getNewsTopHeadlines()
    }
}