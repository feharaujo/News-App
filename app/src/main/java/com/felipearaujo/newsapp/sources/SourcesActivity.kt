package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.felipearaujo.newsapp.BaseActivity
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.databinding.ActivitySourcesBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class SourcesActivity : BaseActivity() {

    @Inject
    lateinit var mViewModelFactory: SourcesViewModelFactory

    val mBinding: ActivitySourcesBinding by lazy {
        DataBindingUtil.setContentView<ActivitySourcesBinding>(this, R.layout.activity_sources)
    }

    val mViewModel: SourcesViewModel by lazy {
        ViewModelProviders.of(this, mViewModelFactory).get(SourcesViewModel::class.java)
    }

    val mLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    val mAdapter: SourcesAdapter by lazy {
        SourcesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sources)

        mBinding.viewModel = mViewModel

        mBinding.rvSources.layoutManager = mLayoutManager
        mBinding.rvSources.setHasFixedSize(true)
        mBinding.rvSources.adapter = mAdapter

        mViewModel.fetchSources().observe(this, Observer {
            if (it != null) {
                mAdapter.addSources(it)
            }
        })
    }
}
