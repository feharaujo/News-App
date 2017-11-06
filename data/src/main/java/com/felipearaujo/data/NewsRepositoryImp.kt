package com.felipearaujo.data

import com.felipearaujo.data.remote.RemoteNewsRepository
import javax.inject.Inject

/**
 * Created by felipearaujo on 04/11/17.
 */
class NewsRepositoryImp constructor(val remoteRepository: RemoteNewsRepository) : NewsRepository {

    override fun fetchSources() {

    }

}