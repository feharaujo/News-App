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
    fun providesSourcesView(activity: SourcesActivity): SourcesView = activity

    @Provides
    fun providesViewModelFactory(repository: NewsRepository): SourcesViewModelFactory =
            SourcesViewModelFactory(repository)

    @Provides
    fun providesSourcesAdapter(view: SourcesView): SourcesAdapter = SourcesAdapter(view)
}