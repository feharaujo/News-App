package com.felipearaujo.data.local.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by felipearaujo on 26/11/17.
 */
open class Source : RealmObject() {
    @PrimaryKey
    var id: String? = null
    var name: String? = null
    var description: String? = null
    var url: String? = null
    var articles: RealmList<Article>? = null
}