package com.felipearaujo.newsapp.sources

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.felipearaujo.newsapp.R
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import javax.inject.Inject

class SourcesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SourcesViewModel
    @Inject
    lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.print()
        Log.v("", "Teste $picasso.isLoggingEnabled")
    }
}
