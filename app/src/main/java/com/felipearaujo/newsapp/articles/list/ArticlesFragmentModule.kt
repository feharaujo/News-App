package com.felipearaujo.newsapp.articles.list

import com.felipearaujo.data.NewsRepository
import com.felipearaujo.newsapp.articles.ArticlesViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 08/11/17.
 */
@Module
class ArticlesFragmentModule {

    @Provides
    fun providesArticlesViewModelFactory(repository: NewsRepository): ArticlesViewModelFactory {
        return ArticlesViewModelFactory(repository)
    }

}