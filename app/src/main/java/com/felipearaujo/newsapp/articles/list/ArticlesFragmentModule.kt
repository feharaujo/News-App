package com.felipearaujo.newsapp.articles.list

import com.felipearaujo.data.NewsRepository
import com.felipearaujo.newsapp.Articles
import com.felipearaujo.newsapp.articles.ArticlesActivity
import com.felipearaujo.newsapp.articles.ArticlesViewModelFactory
import com.squareup.picasso.Picasso
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

    @Provides
    fun providesArticlesAdapter(picasso: Picasso, articlesActivity: Articles): ArticlesAdapter {
        return ArticlesAdapter(picasso, articlesActivity)
    }

    @Provides
    fun providesArticlesActivity(activity: ArticlesActivity): Articles = activity

}