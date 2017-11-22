package com.felipearaujo.newsapp.articles

import com.felipearaujo.newsapp.articles.webview.WebViewFragment
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 21/11/17.
 */
@Module
class WebViewActivityModule {

    @Provides
    fun providesWebViewFragment(): WebViewFragment = WebViewFragment()

}