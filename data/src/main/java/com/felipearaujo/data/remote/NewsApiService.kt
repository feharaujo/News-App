package com.felipearaujo.data.remote

import com.felipearaujo.data.ENDPOINT_ARTICLES
import com.felipearaujo.data.ENDPOINT_SOURCES
import com.felipearaujo.data.PARAM_API_KEY
import com.felipearaujo.data.PARAM_SOURCE
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.SourceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by felipearaujo on 04/11/17.
 */
interface NewsApiService {

    @GET(ENDPOINT_SOURCES)
    fun fetchSources(): Call<SourceResponse>

    @GET(ENDPOINT_ARTICLES)
    fun fetchArticles(@Query(PARAM_API_KEY) apiKey: String,
                      @Query(PARAM_SOURCE) source: String): Call<ArticleResponse>

}