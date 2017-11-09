package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.ViewModelProviders
import com.felipearaujo.data.NewsRepository
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 04/11/17.
 */
@Module
class SourcesActivityModule {

    @Provides
    fun providesSourcesView(activity: SourcesActivity): SourcesView {
        return activity
    }

    @Provides
    fun providesViewModelFactory(repository: NewsRepository): SourcesViewModelFactory {
        return SourcesViewModelFactory(repository)
    }

    @Provides
    fun providesSourcesAdapter(view: SourcesView): SourcesAdapter {
        return SourcesAdapter(view)
    }
}