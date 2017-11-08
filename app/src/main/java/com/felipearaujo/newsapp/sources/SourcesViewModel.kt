package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.felipearaujo.data.NewsRepository
import com.felipearaujo.model.Source
import com.felipearaujo.model.SourceResponse

/**
 * Created by felipearaujo on 04/11/17.
 */
class SourcesViewModel(private val mRepository: NewsRepository) : ViewModel() {

    private val mSourcesLiveData = MediatorLiveData<List<Source>>()
    private var mCacheSourcesResponse: SourceResponse? = null

    // View state
    val loadingStateObservable = ObservableBoolean(false)
    val errorStateObservable = ObservableBoolean(false)
    val dataStateObservable = ObservableBoolean(false)

    val mSourceResponseObserver = Observer<SourceResponse> {
        // cache the response value
        mCacheSourcesResponse = it

        // if there sources
        if (it?.sources != null) {
            mSourcesLiveData.value = it.sources
            notifyDataView()
        } else {
            notifyErrorView()
        }
    }

    fun fetchSources(): LiveData<List<Source>> {
        notifyLoadingView()

        if (mCacheSourcesResponse?.sources != null) {
            mSourcesLiveData.postValue(mCacheSourcesResponse?.sources)
            notifyDataView()
        } else {
            mSourcesLiveData.addSource(
                    mRepository.fetchSources(),
                    mSourceResponseObserver
            )
        }

        return mSourcesLiveData
    }

    private fun notifyLoadingView() {
        loadingStateObservable.set(true)
        errorStateObservable.set(false)
        dataStateObservable.set(false)
    }

    private fun notifyErrorView() {
        loadingStateObservable.set(false)
        errorStateObservable.set(true)
        dataStateObservable.set(false)
    }

    private fun notifyDataView() {
        loadingStateObservable.set(false)
        errorStateObservable.set(false)
        dataStateObservable.set(true)
    }

}
