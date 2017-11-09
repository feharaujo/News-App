package com.felipearaujo.newsapp.di

import com.felipearaujo.newsapp.articles.ArticlesActivity
import com.felipearaujo.newsapp.articles.ArticlesFragmentProvider
import com.felipearaujo.newsapp.sources.SourcesActivity
import com.felipearaujo.newsapp.sources.SourcesActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by felipearaujo on 04/11/17.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(SourcesActivityModule::class))
    abstract fun bindSourcesActivity(): SourcesActivity

    @ContributesAndroidInjector(modules = arrayOf(ArticlesFragmentProvider::class))
    abstract fun ArticlesActivity(): ArticlesActivity

}