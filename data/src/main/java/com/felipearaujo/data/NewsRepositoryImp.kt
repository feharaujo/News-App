package com.felipearaujo.data

import android.arch.lifecycle.LiveData
import com.felipearaujo.data.remote.RemoteNewsRepository
import com.felipearaujo.model.SourceResponse
import javax.inject.Inject

/**
 * Created by felipearaujo on 04/11/17.
 */
class NewsRepositoryImp constructor(val remoteRepository: RemoteNewsRepository) : NewsRepository {

    // TODO : Check connection
    override fun fetchSources(): LiveData<SourceResponse> {
        return remoteRepository.fetchSources()
    }

}