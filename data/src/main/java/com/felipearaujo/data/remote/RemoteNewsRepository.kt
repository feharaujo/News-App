package com.felipearaujo.data.remote

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.SourceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Created by felipearaujo on 05/11/17.
 */
class RemoteNewsRepository(private val service: NewsApiService, private val apiKet: String) {

    fun fetchSources(): MutableLiveData<SourceResponse> {
        val liveData = MutableLiveData<SourceResponse>()

        val call = service.fetchSources()
        call.enqueue(object : Callback<SourceResponse> {
            override fun onResponse(call: Call<SourceResponse>?, response: Response<SourceResponse>?) {
                liveData.value = response?.body()
            }

            override fun onFailure(call: Call<SourceResponse>?, t: Throwable?) {
                liveData.value = SourceResponse(null, null, t)
            }
        })

        return liveData
    }

    fun fetchNews(source: String): MutableLiveData<ArticleResponse> {
        val liveData = MutableLiveData<ArticleResponse>()

        val call = service.fetchArticles(apiKet, source)
        call.enqueue(object : Callback<ArticleResponse> {
            override fun onResponse(call: Call<ArticleResponse>?, response: Response<ArticleResponse>?) {
                liveData.value = response?.body()
            }

            override fun onFailure(call: Call<ArticleResponse>?, t: Throwable?) {
                liveData.value = ArticleResponse(null, null, null, t)
            }
        })

        return liveData
    }

}