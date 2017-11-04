package com.felipearaujo.model

import java.util.*

/**
 * Created by felipearaujo on 04/11/17.
 */
data class Article(
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: Date,
        val author: String?
)