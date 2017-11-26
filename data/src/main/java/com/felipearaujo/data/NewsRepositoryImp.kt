package com.felipearaujo.data

import android.arch.lifecycle.LiveData
import android.content.Context
import android.net.ConnectivityManager
import com.felipearaujo.data.local.LocalNewsRepository
import com.felipearaujo.data.remote.RemoteNewsRepository
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.SourceResponse
import io.realm.Realm


/**
 * Created by felipearaujo on 04/11/17.
 */
class NewsRepositoryImp constructor(
        private val appContext: Context,
        private val remoteRepository: RemoteNewsRepository,
        private val localRepository: LocalNewsRepository
) : NewsRepository {

    init {
        Realm.init(appContext)
    }

    override fun fetchSources(): LiveData<SourceResponse> {
        if (isNetworkConnected()) {
            return remoteRepository.fetchSources()
        } else {
            return localRepository.fetchSources()
        }
    }

    override fun fetchArticles(source: String): LiveData<ArticleResponse> {
        if (isNetworkConnected()) {
            return remoteRepository.fetchArticles(source)
        } else {
            return localRepository.fetchArticles(source)

        }
    }

    /**
     * Check connection
     */
    private fun isNetworkConnected(): Boolean {
        val cm = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

}