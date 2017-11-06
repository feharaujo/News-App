package com.felipearaujo.newsapp.sources

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felipearaujo.newsapp.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class SourcesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SourcesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
