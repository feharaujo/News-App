package com.felipearaujo.data

/**
 * Created by felipearaujo on 04/11/17.
 */

// Url Base
const val URL_BASE = "https://newsapi.org"

// Endpoints
const val ENDPOINT_SOURCES = "/v1/sources"
const val ENDPOINT_ARTICLES = "/v1/articles"

// Endpoint params
const val PARAM_API_KEY = "apiKey"
const val PARAM_SOURCE = "source"

// Intent params
const val INTENT_SOURCE = "source"
const val INTENT_ARTICLE = "article"
const val INTENT_SOURCE_NAME = "source_name"

// Json keys
const val KEY_TITLE = "title"
const val KEY_DESCRIPTION = "description"
const val KEY_URL = "url"
const val KEY_URL_IMAGE = "urlToImage"
const val KEY_URL_DATE = "publishedAt"
const val KEY_URL_AUTHOR = "author"