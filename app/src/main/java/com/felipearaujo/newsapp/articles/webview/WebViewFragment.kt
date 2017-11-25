package com.felipearaujo.newsapp.articles.webview

import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.databinding.FragmentWebViewBinding


/**
 * A simple [Fragment] subclass.
 */
class WebViewFragment : Fragment() {

    private var mBinding: FragmentWebViewBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_web_view, container, false
        )
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding?.loading = false

        configWebView(mBinding?.webview)
        mBinding?.webview?.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView, url: String) {
                mBinding?.loading = false
            }
        }
    }

    /**
     * Load the article in webview
     */
    fun loadUrl(url: String) {
        mBinding?.webview?.loadUrl(url)
        mBinding?.loading = true
    }

    /**
     * Enable render by hardware to improve the webview's performance
     */
    private fun configWebView(webView: WebView?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // chromium, enable hardware acceleration
            webView?.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        } else {
            // older android version, disable hardware acceleration
            webView?.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }

        webView?.webViewClient = WebViewClient()
    }

}
