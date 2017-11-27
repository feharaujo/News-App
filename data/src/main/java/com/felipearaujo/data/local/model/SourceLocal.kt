package com.felipearaujo.data.local.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

/**
 * Created by felipearaujo on 26/11/17.
 */
open class SourceLocal : RealmObject() {
    @PrimaryKey
    @Required
    var id: String? = null
    var name: String? = null
    var description: String? = null
    var url: String? = null
    var articles: RealmList<ArticleLocal>? = null
}