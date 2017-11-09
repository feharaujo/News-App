package com.felipearaujo.data

import android.arch.lifecycle.LiveData
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.SourceResponse

/**
 * Created by felipearaujo on 04/11/17.
 */
interface NewsRepository {

    fun fetchSources(): LiveData<SourceResponse>

    fun fetchArticles(source: String): LiveData<ArticleResponse>

}