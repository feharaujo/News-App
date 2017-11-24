package com.felipearaujo.newsapp.articles.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.databinding.ObservableBoolean
import android.widget.ImageView
import com.felipearaujo.data.NewsRepository
import com.felipearaujo.model.Article
import com.felipearaujo.model.ArticleResponse
import com.squareup.picasso.Picasso

/**
 * Created by felipearaujo on 08/11/17.
 */


class ArticlesViewModel(private val mRepository: NewsRepository) : ViewModel() {

    private val mArticlesLiveData = MediatorLiveData<List<Article>>()
    private var mCacheArticlesResponse: ArticleResponse? = null

    // View state
    val loadingStateObservable = ObservableBoolean(false)
    val errorStateObservable = ObservableBoolean(false)
    val dataStateObservable = ObservableBoolean(false)

    private val mArticleResponseObserver = Observer<ArticleResponse> {
        // cache the response value
        mCacheArticlesResponse = it

        // if there sources
        if (it?.articles != null) {
            mArticlesLiveData.value = it.articles
            notifyDataView()
        } else {
            notifyErrorView()
        }
    }

    fun fetchArticles(source: String): LiveData<List<Article>> {
        notifyLoadingView()

        if (mCacheArticlesResponse?.articles != null) {
            mArticlesLiveData.postValue(mCacheArticlesResponse?.articles)
            notifyDataView()
        } else {
            mArticlesLiveData.addSource(
                    mRepository.fetchArticles(source),
                    mArticleResponseObserver
            )
        }

        return mArticlesLiveData
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