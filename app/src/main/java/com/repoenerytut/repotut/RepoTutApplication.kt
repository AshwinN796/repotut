package com.repoenerytut.repotut

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
@HiltAndroidApp
class RepoTutApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}