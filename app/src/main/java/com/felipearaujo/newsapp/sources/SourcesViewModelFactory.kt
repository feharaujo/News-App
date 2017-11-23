package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.felipearaujo.data.NewsRepository
import javax.inject.Singleton

/**
 * Created by felipearaujo on 04/11/17.
 */
@Suppress("UNCHECKED_CAST")
@Singleton
class SourcesViewModelFactory(private val repository: NewsRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            SourcesViewModel(repository) as T

}