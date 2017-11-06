package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import com.felipearaujo.data.NewsRepository
import com.felipearaujo.model.SourceResponse

/**
 * Created by felipearaujo on 04/11/17.
 */
class SourcesViewModel(private val repository: NewsRepository) : ViewModel() {

    private val sourcesResponse = MediatorLiveData<SourceResponse>()

    fun fetchSources(): LiveData<SourceResponse> {
        sourcesResponse.addSource(
                repository.fetchSources(),
                Observer {
                    sourcesResponse.value = it
                }
        )

        return sourcesResponse
    }

}
