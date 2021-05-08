package com.repoenerytut.repotut.extension

import android.app.Activity
import android.widget.Toast

/**
 * Created by Ashwin Nirmale on 08/05/21.
 */

fun Activity.toast(message: String) {
    runOnUiThread { Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }
}