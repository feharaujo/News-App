package com.felipearaujo.newsapp.articles

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.felipearaujo.data.NewsRepository
import com.felipearaujo.newsapp.sources.SourcesViewModel
import javax.inject.Singleton

/**
 * Created by felipearaujo on 08/11/17.
 */
@Suppress("UNCHECKED_CAST")
@Singleton
class ArticlesViewModelFactory(val repository: NewsRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArticlesViewModel(repository) as T
    }

}