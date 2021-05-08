package com.repoenerytut.repotut.interactor.cases

import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.data.repository.DataRepository
import com.repoenerytut.repotut.interactor.base.BaseUseCase
import com.repoenerytut.repotut.interactor.response.NewsHeadingItem
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse
import javax.inject.Inject

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
class NewsHeadlineCase @Inject constructor(private val repository: DataRepository): BaseUseCase<Void,NetworkResponse<NewsHeadingResponse>>() {
    override suspend fun invoke(parameters: Void?): NetworkResponse<NewsHeadingResponse> {
        return repository.getNewsTopHeadlines()
    }

}