package com.repoenerytut.repotut.viewModel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.repoenerytut.repotut.data.TestRemoteDataSource
import com.repoenerytut.repotut.data.repository.DataRepositoryImpl
import com.repoenerytut.repotut.interactor.cases.NewsHeadlineCase
import com.repoenerytut.repotut.ui.newsheading.NewsViewModel
import com.repoenerytut.repotut.util.MainCoroutineRule
import com.repoenerytut.repotut.util.runBlockingTest
import com.repoenerytut.repotut.utilities.NetworkHelper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

/**
 * Created by Ashwin Nirmale on 10/05/21.
 */
@ExperimentalCoroutinesApi
class NewsHeadingViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get: Rule
    var coroutine = MainCoroutineRule()

    private val deafultRepository = DataRepositoryImpl(null,TestRemoteDataSource)


    @Test
    fun getNewsHeading() = coroutine.runBlockingTest {
        val newsCase = NewsHeadlineCase(deafultRepository)
        val viewModel = NewsViewModel(newsCase)

    }

}