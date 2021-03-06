package com.felipearaujo.newsapp.articles.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.felipearaujo.data.NewsRepository
import javax.inject.Singleton

/**
 * Created by felipearaujo on 08/11/17.
 */
@Suppress("UNCHECKED_CAST")
@Singleton
class ArticlesViewModelFactory(private val repository: NewsRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            ArticlesViewModel(repository) as T

}