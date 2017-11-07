package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.felipearaujo.data.NewsRepository
import com.felipearaujo.model.SourceResponse

/**
 * Created by felipearaujo on 04/11/17.
 */
class SourcesViewModel(private val repository: NewsRepository) : ViewModel() {

    private val sourcesResponse = MediatorLiveData<SourceResponse>()
    private var cacheSourcesResponse: SourceResponse? = null

    val loading = ObservableBoolean(false)

    fun fetchSources(): LiveData<SourceResponse> {
        if(cacheSourcesResponse != null) {
            sourcesResponse.postValue(cacheSourcesResponse)
        } else {
            sourcesResponse.addSource(
                    repository.fetchSources(),
                    Observer {
                        cacheSourcesResponse = it
                        sourcesResponse.value = it
                    }
            )
        }

        return sourcesResponse
    }

}
