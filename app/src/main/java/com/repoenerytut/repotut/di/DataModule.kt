package com.repoenerytut.repotut.di

import com.repoenerytut.repotut.data.coroutines.DispatcherProvider
import com.repoenerytut.repotut.data.remote.RemoteDataSource
import com.repoenerytut.repotut.data.remote.RemoteDataSourceImpl
import com.repoenerytut.repotut.data.remote.RestService
import com.repoenerytut.repotut.data.repository.DataRepository
import com.repoenerytut.repotut.data.repository.DataRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */

@InstallIn(ApplicationComponent::class)
@Module
@ExperimentalCoroutinesApi
object DataModule {

    @Provides
    fun provideRemoteDataSource(apiService: RestService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideDataRepository(
        dispatcherProvider: DispatcherProvider,
        remoteDataSource: RemoteDataSource,
    ): DataRepository {
        return DataRepositoryImpl(dispatcherProvider, remoteDataSource)
    }
}