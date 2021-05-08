package com.repoenerytut.repotut.di

import android.content.Context
import com.repoenerytut.repotut.data.remote.RestService
import com.repoenerytut.repotut.data.remote.RestServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */

@InstallIn(ApplicationComponent::class)
@Module
object NetWorkModule {

    @Singleton
    @Provides
    fun provideRestService() : RestService {
        return RestServiceFactory.makeRestService()
    }

    @Provides
    fun provideContext(): Context {
        return provideContext()
    }

}