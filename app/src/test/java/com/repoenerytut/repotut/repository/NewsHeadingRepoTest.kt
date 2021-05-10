package com.repoenerytut.repotut.repository

import com.nhaarman.mockitokotlin2.mock
import com.repoenerytut.repotut.data.remote.RemoteDataSource
import com.repoenerytut.repotut.data.repository.DataRepository
import com.repoenerytut.repotut.data.repository.DataRepositoryImpl

/**
 * Created by Ashwin Nirmale on 10/05/21.
 */
class NewsHeadingRepoTest {

    lateinit var remoteDataSource: RemoteDataSource
    private lateinit var repository: DataRepositoryImpl

    fun setUp() {
        remoteDataSource = mock()
    }

}