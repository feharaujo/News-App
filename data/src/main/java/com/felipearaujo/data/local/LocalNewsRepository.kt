package com.felipearaujo.data.local

import com.felipearaujo.data.NewsRepository
import com.felipearaujo.model.Article
import com.felipearaujo.model.Source

/**
 * Created by felipearaujo on 26/11/17.
 */
interface LocalNewsRepository : NewsRepository {

    fun saveSources(sources: List<Source>)

    fun saveArticles(id: String, articles: List<Article>)

}