package com.repoenerytut.repotut.ui.newsheading.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.repoenerytut.repotut.R
import com.repoenerytut.repotut.databinding.ItemNewsHeaderBinding
import com.repoenerytut.repotut.extension.loadImageFromUrl
import com.repoenerytut.repotut.interactor.response.NewsHeadingItem

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
class NewsHeadingAdapter(private val activity: Activity,
                         private val list: List<NewsHeadingItem>): RecyclerView.Adapter<NewsHeadingAdapter.NewsHeadingHolder>() {

    class NewsHeadingHolder(val binding: ItemNewsHeaderBinding): RecyclerView.ViewHolder(binding.root)

    var onNewsClick: ((cardView: CardView, data: NewsHeadingItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHeadingHolder {
        val binding = DataBindingUtil.inflate<ItemNewsHeaderBinding>(
            LayoutInflater.from(parent.context), R.layout.item_news_header, parent, false)

        val holder = NewsHeadingHolder(binding)

        holder.binding.parentItem.setOnClickListener {
            val item = list[holder.adapterPosition]
            onNewsClick?.invoke(holder.binding.parentItem,item)
        }

        return holder
    }

    override fun onBindViewHolder(holder: NewsHeadingHolder, position: Int) {
        val item = list[position]

        holder.binding.newsImage.loadImageFromUrl(activity,item.urlToImage,R.mipmap.ic_launcher)
        holder.binding.headerText.text = item.title
        holder.binding.descriptionText.text = item.description
        holder.binding.sourceName.text = item.source?.name
        holder.binding.sourceDate.text = item.publishedAt
    }

    override fun getItemCount(): Int {
        return list.size
    }


}