package com.felipearaujo.data

import android.arch.lifecycle.LiveData
import com.felipearaujo.data.remote.RemoteNewsRepository
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.SourceResponse

/**
 * Created by felipearaujo on 04/11/17.
 */
class NewsRepositoryImp constructor(private val remoteRepository: RemoteNewsRepository) : NewsRepository {

    // TODO : Check connection
    override fun fetchSources(): LiveData<SourceResponse> {
        return remoteRepository.fetchSources()
    }

    override fun fetchArticles(source: String): LiveData<ArticleResponse> {
        return remoteRepository.fetchNews(source)
    }

}