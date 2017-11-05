package com.felipearaujo.newsapp.sources

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by felipearaujo on 04/11/17.
 */
@Suppress("UNCHECKED_CAST")
class SourcesViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SourcesViewModel() as T
    }

}