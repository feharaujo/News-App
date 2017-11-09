package com.felipearaujo.newsapp.articles

import com.felipearaujo.newsapp.articles.list.ArticlesFragmentModule
import com.felipearaujo.newsapp.articles.list.ArticlesListFragment
import com.felipearaujo.newsapp.articles.webview.WebViewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by felipearaujo on 08/11/17.
 */
@Module
abstract class ArticlesFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(ArticlesFragmentModule::class))
    abstract fun providesArticlesFragment(): ArticlesListFragment

    @ContributesAndroidInjector
    abstract fun providesWebViewFragment(): WebViewFragment

}