package com.repoenerytut.repotut.ui.newsheading

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.repoenerytut.repotut.R
import com.repoenerytut.repotut.data.remote.factory.NetworkResponse
import com.repoenerytut.repotut.databinding.ActivityNewsHeadingBinding
import com.repoenerytut.repotut.extension.gone
import com.repoenerytut.repotut.extension.toast
import com.repoenerytut.repotut.extension.visible
import com.repoenerytut.repotut.ui.base.BaseActivity
import com.repoenerytut.repotut.ui.newsheading.adapter.NewsHeadingAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */

@AndroidEntryPoint
class NewsHeadingList: BaseActivity<ActivityNewsHeadingBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_news_heading

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "News"

        viewModel.getNewsHeadingList()
    }

    override fun setupObserver() {
        super.setupObserver()

        viewModel.newHeadingLiveData.observe(this) { result ->
            when(result) {
                is NetworkResponse.Loading -> {
                    showProgressbar(true)
                }

                is NetworkResponse.Error -> {
                    showProgressbar(false)

                    if (result.code == 0) {
                        toast("Network Error")
                    }else {
                        toast(result.error?.toString()!!)
                    }
                }

                is NetworkResponse.Success -> {
                    showProgressbar(false)
                    val adapter = NewsHeadingAdapter(this,result.body?.articles!!).apply {
                        onNewsClick = { cardView, data ->
                            val compat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                this@NewsHeadingList,
                                cardView,
                                cardView.transitionName)

                            startActivity(NewsDetailActivity.newInstance(this@NewsHeadingList,data),compat.toBundle())
                        }
                    }

                    bindView?.newsRecyclerView?.adapter = adapter
                }
            }
        }
    }

    override fun setupListener() {
        super.setupListener()
        bindView?.newsRecyclerView?.layoutManager = LinearLayoutManager(this)
    }

    private fun showProgressbar(status: Boolean) {
        if (status) {
            bindView?.progressBar?.visible()
        }else {
            bindView?.progressBar?.gone()
        }
    }
}