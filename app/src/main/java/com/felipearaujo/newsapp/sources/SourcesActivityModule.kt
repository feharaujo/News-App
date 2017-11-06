package com.felipearaujo.newsapp.sources

import com.felipearaujo.data.NewsRepository
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 04/11/17.
 */
@Module
class SourcesActivityModule {

    @Provides
    fun providesViewModel(repository: NewsRepository): SourcesViewModel {
        return SourcesViewModelFactory(repository).create(SourcesViewModel::class.java)
    }


}