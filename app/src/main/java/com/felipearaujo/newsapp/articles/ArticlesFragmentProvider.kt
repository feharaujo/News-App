package com.felipearaujo.newsapp.articles

import com.felipearaujo.data.NewsRepository
import com.felipearaujo.newsapp.articles.list.ArticlesFragmentModule
import com.felipearaujo.newsapp.articles.list.ArticlesListFragment
import com.felipearaujo.newsapp.sources.SourcesViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by felipearaujo on 08/11/17.
 */
@Module
abstract class ArticlesFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(ArticlesFragmentModule::class))
    abstract fun providesArticlesFragment(): ArticlesListFragment

}