package com.repoenerytut.repotut.ui.other

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.repoenerytut.repotut.R
import com.repoenerytut.repotut.databinding.ActivityOpenWebBinding
import com.repoenerytut.repotut.ui.base.BaseActivity

/**
 * Created by Ashwin Nirmale on 08/05/21.
 */
class OpenWebActivity: BaseActivity<ActivityOpenWebBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_open_web


    private var webUrl: String? = null
    private var toolTitle: String? = null

    companion object {
        fun newInstance(context: Context,
                        webUrl: String,
                        title: String): Intent = Intent(context,OpenWebActivity::class.java).apply {
                            putExtra("webUrl",webUrl)
                            putExtra("title",title)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent != null) {
            webUrl = intent.getStringExtra("webUrl")
            toolTitle = intent.getStringExtra("title")
        }

        title = toolTitle
        enableBack()
        bindView?.appWebView?.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                showProgress(false)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                showProgress(true)
            }
        }

        bindView?.appWebView?.loadUrl(webUrl!!)
    }

    private fun showProgress(show: Boolean) {
        bindView?.appWebView?.visibility = if (show) View.INVISIBLE else View.VISIBLE
        bindView?.progressBar?.visibility = if (show) View.VISIBLE else View.GONE
    }
}