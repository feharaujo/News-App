package com.felipearaujo.data.local

import com.felipearaujo.data.local.model.ArticleLocal
import com.felipearaujo.data.local.model.SourceLocal
import com.felipearaujo.model.Article
import com.felipearaujo.model.Source
import java.util.*

/**
 * Created by felipearaujo on 26/11/17.
 */
class LocalModelConverter {

    /**
     * Extension to convert a Ui Source to a Local Source
     */
    fun Source.convertToLocalModel(): SourceLocal {
        val sourceLocal = SourceLocal()
        sourceLocal.id = this.id
        sourceLocal.description = this.description
        sourceLocal.name = this.name
        sourceLocal.url = this.url

        return sourceLocal
    }

    /**
     * Extension to convert a Local Source to a Ui Source
     */
    fun SourceLocal.convertToUiModel(): Source {
        return Source(
                this.id ?: "",
                this.name ?: "",
                this.description ?: "",
                this.url ?: ""
        )
    }

    /**
     * Extension to convert a Ui Article to a Local Article
     */
    fun Article.convertToLocalModel(): ArticleLocal {
        val articleLocal = ArticleLocal()
        articleLocal.title = this.title
        articleLocal.author = this.author
        articleLocal.description = this.description
        articleLocal.publishedAt = this.publishedAt
        articleLocal.url = this.url
        articleLocal.urlToImage = this.urlToImage

        return articleLocal
    }

    /**
     * Extension to convert a Local Article to a Ui Article
     */
    fun ArticleLocal.convertToUiModel(): Article {
        return Article(
                this.title ?: "",
                this.description ?: "",
                this.url ?: "",
                this.urlToImage ?: "",
                this.publishedAt ?: Date(Long.MIN_VALUE),
                this.author ?: ""
        )
    }

}