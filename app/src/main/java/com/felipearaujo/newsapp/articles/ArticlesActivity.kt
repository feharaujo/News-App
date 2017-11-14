package com.felipearaujo.newsapp.articles

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.FrameLayout
import com.felipearaujo.data.INTENT_SOURCE
import com.felipearaujo.model.Article
import com.felipearaujo.model.Source
import com.felipearaujo.newsapp.Articles
import com.felipearaujo.newsapp.BaseActivity
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.articles.list.ArticlesListFragment
import com.felipearaujo.newsapp.articles.webview.WebViewFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class ArticlesActivity : BaseActivity(), Articles, HasSupportFragmentInjector {


    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var articlesFragment: ArticlesListFragment

    private val webviewFragment by lazy {
        WebViewFragment()
    }

    private val mSource: Source by lazy {
        intent.getParcelableExtra<Source>(INTENT_SOURCE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        title = mSource.name

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        configFragments()
    }

    fun configFragments() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_articles, articlesFragment)

        // Tablet
        if (isTablet()) {
            transaction.replace(R.id.fragment_webview, webviewFragment)
        }

        transaction.commit()
    }

    override fun selectedArticle(article: Article) {
        if(isTablet()) {
            webviewFragment.loadUrl(article.url)
        }

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    private fun isTablet(): Boolean {
        return findViewById<FrameLayout>(R.id.fragment_webview) != null
    }
}
