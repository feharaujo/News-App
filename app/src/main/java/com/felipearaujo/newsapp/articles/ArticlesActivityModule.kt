package com.felipearaujo.newsapp.articles

import com.felipearaujo.newsapp.articles.list.ArticlesListFragment
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 11/11/17.
 */
@Module
class ArticlesActivityModule {

    @Provides
    fun providesArticlesFragment(): ArticlesListFragment = ArticlesListFragment()

}