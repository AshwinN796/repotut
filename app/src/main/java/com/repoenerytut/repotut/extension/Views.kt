package com.repoenerytut.repotut.extension

import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.io.File

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */


fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}


fun ImageView.loadImageFromUrl(
    activity: Activity,
    path: String?,
    placeholder: Int,
    isLocal: Boolean = false,
    circularTranformation: Boolean = false
) {
    var finalPath: String? = path
    if (finalPath.isNullOrEmpty()) {
        finalPath = null
    }

    if (!activity.isFinishing) {
        if (isLocal) {
            val f = File(path)
            if (circularTranformation) {
                Glide.with(activity)
                    .load(f)
                    .centerCrop()
                    .apply(RequestOptions.circleCropTransform())
                    .placeholder(placeholder)
                    .into(this)
            } else {

                Glide.with(activity)
                    .load(f)
                    .placeholder(placeholder)
                    .centerCrop().into(this)

            }
        } else {
            if (circularTranformation) {
                Glide.with(activity)
                    .load(finalPath)
                    .centerCrop()
                    .apply(RequestOptions.circleCropTransform())
                    .placeholder(placeholder).into(this)
            } else {
                Glide.with(activity)
                    .load(finalPath)
                    .centerCrop()
                    .placeholder(placeholder).into(this)
            }
        }
    }
}