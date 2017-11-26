package com.felipearaujo.newsapp.articles.list

import com.felipearaujo.data.NewsRepository
import com.felipearaujo.newsapp.Articles
import com.felipearaujo.newsapp.articles.ArticlesActivity
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 08/11/17.
 */
@Module
class ArticlesFragmentModule {

    @Provides
    fun providesArticlesViewModelFactory(repository: NewsRepository): ArticlesViewModelFactory =
            ArticlesViewModelFactory(repository)

    @Provides
    fun providesArticlesAdapter(articlesActivity: Articles): ArticlesAdapter =
            ArticlesAdapter(articlesActivity)

    @Provides
    fun providesArticlesActivity(activity: ArticlesActivity): Articles = activity

}