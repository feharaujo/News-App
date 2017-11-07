package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.databinding.ActivitySourcesBinding
import dagger.android.AndroidInjection
import org.jetbrains.anko.toast
import javax.inject.Inject

class SourcesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: SourcesViewModelFactory

    val binding: ActivitySourcesBinding by lazy {
        DataBindingUtil.setContentView<ActivitySourcesBinding>(this, R.layout.activity_sources)
    }

    val viewModel: SourcesViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SourcesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sources)

        binding.viewModel = viewModel

        viewModel.fetchSources().observe(this, Observer {
            if (it != null && it.throwable == null) {
                toast("Success!")
            } else {
                toast("Fail")
            }
        })
    }
}
