package com.felipearaujo.newsapp.articles.list

import com.felipearaujo.data.NewsRepository
import com.felipearaujo.newsapp.Articles
import com.felipearaujo.newsapp.articles.ArticlesActivity
import com.squareup.picasso.Picasso
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
    fun providesArticlesAdapter(picasso: Picasso, articlesActivity: Articles): ArticlesAdapter =
            ArticlesAdapter(picasso, articlesActivity)

    @Provides
    fun providesArticlesActivity(activity: ArticlesActivity): Articles = activity

}