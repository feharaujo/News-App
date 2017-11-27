package com.felipearaujo.data.remote

import android.arch.lifecycle.MutableLiveData
import com.felipearaujo.data.local.LocalNewsRepository
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.SourceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by felipearaujo on 05/11/17.
 */
class RemoteNewsRepositoryImp(
        private val service: NewsApiService,
        private val apiKet: String,
        private val localNewsRepository: LocalNewsRepository
) : RemoteNewsRepository {

    /**
     * Search all sources
     */
    override fun fetchSources(): MutableLiveData<SourceResponse> {
        val liveData = MutableLiveData<SourceResponse>()

        val call = service.fetchSources()
        call.enqueue(object : Callback<SourceResponse> {
            override fun onResponse(call: Call<SourceResponse>?, response: Response<SourceResponse>?) {
                val responseBody = response?.body()
                val sources = responseBody?.sources
                if (sources != null) {
                    localNewsRepository.saveSources(sources)
                }
                liveData.value = responseBody
            }

            override fun onFailure(call: Call<SourceResponse>?, t: Throwable?) {
                liveData.value = SourceResponse(null, t)
            }
        })

        return liveData
    }

    /**
     * Search all articles by source id
     */
    override fun fetchArticles(source: String): MutableLiveData<ArticleResponse> {
        val liveData = MutableLiveData<ArticleResponse>()

        val call = service.fetchArticles(apiKet, source)
        call.enqueue(object : Callback<ArticleResponse> {
            override fun onResponse(call: Call<ArticleResponse>?, response: Response<ArticleResponse>?) {
                val responseBody = response?.body()
                val articles = responseBody?.articles
                if (articles != null) {
                    localNewsRepository.saveArticles(source, articles)
                }
                liveData.value = response?.body()
            }

            override fun onFailure(call: Call<ArticleResponse>?, t: Throwable?) {
                liveData.value = ArticleResponse(null, null, t)
            }
        })

        return liveData
    }

}