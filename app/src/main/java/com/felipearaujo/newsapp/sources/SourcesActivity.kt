package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.felipearaujo.newsapp.R
import dagger.android.AndroidInjection
import org.jetbrains.anko.toast
import javax.inject.Inject

class SourcesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SourcesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchSources().observe(this, Observer {
            if(it != null && it.throwable == null) {
                toast("Sucesso!")
            } else {
                toast("Falhou")
            }
        })
    }
}
