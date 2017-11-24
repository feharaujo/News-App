package com.felipearaujo.newsapp.articles

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.felipearaujo.data.INTENT_ARTICLE
import com.felipearaujo.data.INTENT_SOURCE_NAME
import com.felipearaujo.model.Article
import com.felipearaujo.newsapp.BaseActivity
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.articles.webview.WebViewFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class WebViewActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var webViewFragment: WebViewFragment

    private val mArticle: Article by lazy {
        intent.getParcelableExtra<Article>(INTENT_ARTICLE)
    }

    private val mSourceName: String by lazy {
        intent.getStringExtra(INTENT_SOURCE_NAME)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        title = mSourceName

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        configFragments()
    }

    override fun onResume() {
        super.onResume()

        val url = mArticle.url
        if (url != null) {
            webViewFragment.loadUrl(url)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun configFragments() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_webview, webViewFragment)
        transaction.commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentDispatchingAndroidInjector
}
