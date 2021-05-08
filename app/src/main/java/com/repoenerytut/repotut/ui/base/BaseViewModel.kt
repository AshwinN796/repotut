package com.repoenerytut.repotut.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ashwin Nirmale on 07/05/21.
 */
open class BaseViewModel : ViewModel(){
    val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}