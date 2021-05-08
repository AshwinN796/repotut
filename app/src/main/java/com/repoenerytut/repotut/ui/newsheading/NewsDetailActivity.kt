package com.repoenerytut.repotut.ui.newsheading

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.text.*
import com.google.android.material.appbar.AppBarLayout
import com.repoenerytut.repotut.R
import com.repoenerytut.repotut.databinding.ActivityNewsDetailBinding
import com.repoenerytut.repotut.extension.loadImageFromUrl
import com.repoenerytut.repotut.interactor.response.NewsHeadingItem
import com.repoenerytut.repotut.ui.base.BaseActivity
import com.repoenerytut.repotut.ui.other.OpenWebActivity

/**
 * Created by Ashwin Nirmale on 08/05/21.
 */
class NewsDetailActivity: BaseActivity<ActivityNewsDetailBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_news_detail

    private var newsData: NewsHeadingItem? = null

    companion object {
        fun newInstance(context: Context,
                        newsData: NewsHeadingItem): Intent = Intent(context,NewsDetailActivity::class.java).apply {
            putExtra("newsData",newsData)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent != null) {
            newsData = intent.getParcelableExtra("newsData")
        }

        if (newsData != null) {
            setSupportActionBar(bindView?.newsDetailToolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            initCollapsingToolbar(newsData?.source?.name!!)
            setUpUiData(newsData!!)
        }else {
            //show something went wrong error or
            //finish()
        }
    }
    override fun setupListener() {
        super.setupListener()

        bindView?.descriptionText?.setOnClickListener {
            startActivity(OpenWebActivity.newInstance(this,newsData?.url!!,newsData?.source?.name!!))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finishAfterTransition()
        }
        return true
    }

    private fun initCollapsingToolbar(titleName: String) {
        bindView?.newsDetailCollapsingBar?.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white))
        bindView?.newsDetailCollapsingBar?.setExpandedTitleColor(Color.WHITE)
        bindView?.newsDetailCollapsingBar?.setCollapsedTitleTextColor(Color.WHITE)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        bindView?.newsDetailAppBar?.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = true
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    bindView?.newsDetailCollapsingBar?.title = titleName
                    isShow = true
                } else if (isShow) {
                    bindView?.newsDetailCollapsingBar?.setExpandedTitleColor(Color.WHITE)
                    bindView?.newsDetailCollapsingBar?.title = titleName
                    isShow = false
                }
            }
        })
    }

    private fun setUpUiData(newsData: NewsHeadingItem) {
        bindView?.newsImage?.loadImageFromUrl(this,newsData.urlToImage,R.mipmap.ic_launcher)
        bindView?.headerText?.text = newsData.title
        if (newsData.description != null) {
            bindView?.descriptionText?.text = buildSpannedString {
                append(newsData.description)
                inSpans(ForegroundColorSpan(ContextCompat.getColor(bindView?.descriptionText?.context!!,R.color.grey_400))) {
                    append(" Read More")
                }
            }
        }
    }

}