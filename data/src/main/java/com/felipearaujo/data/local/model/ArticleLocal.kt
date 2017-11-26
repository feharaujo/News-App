package com.felipearaujo.data.local.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by felipearaujo on 26/11/17.
 */
open class ArticleLocal : RealmObject() {
    @PrimaryKey
    var id: Int? = null
    var title: String? = null
    var description: String? = null
    var url: String? = null
    var urlToImage: String? = null
    var publishedAt: Date? = null
    var author: String? = null
}