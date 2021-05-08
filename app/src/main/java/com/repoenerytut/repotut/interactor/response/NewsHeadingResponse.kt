package com.repoenerytut.repotut.interactor.response

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
data class NewsHeadingResponse (
    val status: Boolean? = null,
    val totalResults: Int? = null,
    val articles: List<NewsHeadingItem>? = null
        )