package com.felipearaujo.newsapp.articles

import com.felipearaujo.newsapp.articles.webview.WebViewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by felipearaujo on 08/11/17.
 */
@Module
abstract class WebViewFragmentProvider {

    @ContributesAndroidInjector
    abstract fun providesWebViewFragment(): WebViewFragment

}