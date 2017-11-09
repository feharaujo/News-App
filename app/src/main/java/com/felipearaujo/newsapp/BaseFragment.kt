package com.felipearaujo.newsapp

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.felipearaujo.newsapp.sources.SourcesViewModel
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

/**
 * Created by felipearaujo on 08/11/17.
 */
open class BaseFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Performe injection
        AndroidSupportInjection.inject(this)

        super.onCreate(savedInstanceState)
    }

}