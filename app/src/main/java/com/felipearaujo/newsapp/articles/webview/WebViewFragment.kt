package com.felipearaujo.newsapp.articles.webview


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.felipearaujo.newsapp.R


/**
 * A simple [Fragment] subclass.
 */
class WebViewFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

}// Required empty public constructor
