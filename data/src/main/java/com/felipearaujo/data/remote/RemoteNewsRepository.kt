package com.felipearaujo.data.remote

import retrofit2.Retrofit

/**
 * Created by felipearaujo on 05/11/17.
 */
class RemoteNewsRepository constructor(retrofit: Retrofit) {

    val service: NewsApiService

    init {
        service = retrofit.create(NewsApiService::class.java)
    }

}