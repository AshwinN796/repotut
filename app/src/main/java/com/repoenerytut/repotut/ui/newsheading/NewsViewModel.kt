package com.repoenerytut.repotut.ui.newsheading

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.interactor.cases.NewsHeadlineCase
import com.repoenerytut.repotut.interactor.response.NewsHeadingResponse
import com.repoenerytut.repotut.ui.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
class NewsViewModel @ViewModelInject constructor(
    private val newsHeadlineCase: NewsHeadlineCase
): BaseViewModel(){

    val newHeadingLiveData = MutableLiveData<NetworkResponse<NewsHeadingResponse>>()

    fun getNewsHeadingList() {
        newHeadingLiveData.postValue(NetworkResponse.Loading())
        viewModelScope.launch {
            newHeadingLiveData.postValue(newsHeadlineCase.invoke(null))
        }
    }

}