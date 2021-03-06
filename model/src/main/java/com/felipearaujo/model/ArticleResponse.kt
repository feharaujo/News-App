package com.felipearaujo.model

/**
 * Created by felipearaujo on 04/11/17.
 */
data class ArticleResponse(
        val source: String?,
        val articles: List<Article>?,
        @Transient val throwable: Throwable?
)