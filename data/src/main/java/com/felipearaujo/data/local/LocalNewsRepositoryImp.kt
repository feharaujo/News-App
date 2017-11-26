package com.felipearaujo.data.local

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.felipearaujo.data.NewsRepository
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.SourceResponse
import io.realm.Realm

/**
 * Created by felipearaujo on 26/11/17.
 */
class LocalNewsRepository(private val realm: Realm) : NewsRepository {

    override fun fetchSources(): LiveData<SourceResponse> {
        val liveData = MutableLiveData<SourceResponse>()

        realm.executeTransactionAsync {
            
        }
    }

    override fun fetchArticles(source: String): LiveData<ArticleResponse> {
    }
}