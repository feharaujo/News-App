package com.felipearaujo.newsapp.sources

import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 04/11/17.
 */
@Module
class SourcesActivityModule {

    @Provides
    fun providesViewModel(): SourcesViewModel {
        return SourcesViewModelFactory().create(SourcesViewModel::class.java)
    }


}