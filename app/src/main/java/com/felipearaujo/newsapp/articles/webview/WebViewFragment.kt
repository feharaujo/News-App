package com.felipearaujo.newsapp.articles.webview


import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.databinding.FragmentWebViewBinding


/**
 * A simple [Fragment] subclass.
 */
class WebViewFragment : Fragment() {

    // TODO : Webview config

    var mBinding: FragmentWebViewBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_web_view, container, false
        )
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configWebView()
    }

    /**
     * Load the article in webview
     */
    fun loadUrl(url: String) {
        mBinding?.webview?.loadUrl(url)
    }

    /**
     * Enable hardware render to improve the webview's performance
     */
    private fun configWebView() {
        val webView = mBinding?.webview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // chromium, enable hardware acceleration
            webView?.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        } else {
            // older android version, disable hardware acceleration
            webView?.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
    }

}
