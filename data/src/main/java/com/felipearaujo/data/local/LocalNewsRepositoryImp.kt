package com.felipearaujo.data.local

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.felipearaujo.data.local.model.ArticleLocal
import com.felipearaujo.data.local.model.SourceLocal
import com.felipearaujo.model.Article
import com.felipearaujo.model.ArticleResponse
import com.felipearaujo.model.Source
import com.felipearaujo.model.SourceResponse
import io.realm.Realm
import io.realm.RealmList


/**
 * Created by felipearaujo on 26/11/17.
 */
class LocalNewsRepositoryImp(private val realm: Realm) : LocalNewsRepository {

    override fun fetchSources(): LiveData<SourceResponse> {
        val liveData = MutableLiveData<SourceResponse>()
        val listSources = ArrayList<Source>()

        realm.executeTransactionAsync({
            val sourcesLocal = it.where(SourceLocal::class.java).findAll()
            sourcesLocal.forEach {
                listSources.add(it.convertToUiModel())
            }

        }, {
            // onComplete
            liveData.value = SourceResponse(listSources, null)
        }, {
            // onError
            liveData.value = SourceResponse(null, it)
        })

        return liveData
    }

    override fun fetchArticles(id: String): LiveData<ArticleResponse> {
        val liveData = MutableLiveData<ArticleResponse>()
        val listArticles = ArrayList<Article>()

        realm.executeTransactionAsync({
            val result = it.where(SourceLocal::class.java).equalTo("id", id).findFirst()
            if (result?.articles != null) {
                result.articles?.forEach {
                    listArticles.add(it.convertToUiModel())
                }
            }
        }, {
            // onComplete
            liveData.value = ArticleResponse(id, listArticles, null)
        }, {
            // onError
            liveData.value = ArticleResponse(null, null, it)
        })

        return liveData
    }

    override fun saveSources(sources: List<Source>) {
        realm.executeTransactionAsync {
            it.deleteAll()
            val listSourcesLocal = ArrayList<SourceLocal>()
            sources.forEach {
                listSourcesLocal.add(it.convertToLocalModel())
            }
            it.insert(listSourcesLocal)
        }
    }

    override fun saveArticles(id: String, articles: List<Article>) {
        realm.executeTransactionAsync(Realm.Transaction {
            val result = it.where(SourceLocal::class.java).equalTo("id", id).findFirst()
            if (result != null) {
                val realmList = RealmList<ArticleLocal>()
                var incrementId = getPrimaryKeyNumber(it)

                articles.forEach {
                    val local = it.convertToLocalModel()
                    incrementId += 1
                    local.id = incrementId
                    realmList.add(local)
                }
                result.articles?.deleteAllFromRealm()
                result.articles?.addAll(realmList)
                it.insertOrUpdate(result)
            }

        }, Realm.Transaction.OnError {
            Log.e("News", it.toString())
        })

    }

    private fun getPrimaryKeyNumber(realm: Realm) : Int {
        val nextID = realm.where(ArticleLocal::class.java).max("id")
        if (nextID == null) {
            return 0
        } else {
            return nextID.toInt() + 1
        }
    }
}