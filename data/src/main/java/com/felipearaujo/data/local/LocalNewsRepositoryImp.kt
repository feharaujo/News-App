package com.felipearaujo.data.local

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.felipearaujo.data.local.model.ArticleLocal
import com.felipearaujo.data.local.model.SourceLocal
import com.felipearaujo.model.Article
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.Source
import com.felipearaujo.model.SourceResponse
import io.realm.Realm

/**
 * Created by felipearaujo on 26/11/17.
 */
class LocalNewsRepositoryImp(private val realm: Realm) : LocalNewsRepository {

    override fun fetchSources(): LiveData<SourceResponse> {
        val liveData = MutableLiveData<SourceResponse>()

        realm.executeTransactionAsync {

        }

        return liveData
    }

    override fun fetchArticles(source: String): LiveData<ArticleResponse> {
        val liveData = MutableLiveData<ArticleResponse>()

        realm.executeTransactionAsync {

        }

        return liveData
    }

    override fun saveSources(sources: List<Source>) {

    }

    override fun saveArticles(id: String, articles: List<Article>) {

    }

    override fun deleteAllSources() {
        realm.delete(SourceLocal::class.java)
    }

    override fun deleteAllArticles() {
        realm.delete(ArticleLocal::class.java)
    }
}