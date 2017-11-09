package com.felipearaujo.newsapp.sources

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.felipearaujo.model.Source
import com.felipearaujo.newsapp.BaseActivity
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.articles.ArticlesActivity
import com.felipearaujo.newsapp.databinding.ActivitySourcesBinding
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import javax.inject.Inject

class SourcesActivity : BaseActivity(), SourcesView {

    @Inject
    lateinit var mViewModelFactory: SourcesViewModelFactory
    @Inject
    lateinit var mAdapter: SourcesAdapter

    val mBinding: ActivitySourcesBinding by lazy {
        DataBindingUtil.setContentView<ActivitySourcesBinding>(this, R.layout.activity_sources)
    }

    val mViewModel: SourcesViewModel by lazy {
        ViewModelProviders.of(this, mViewModelFactory).get(SourcesViewModel::class.java)
    }

    val mLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sources)

        mBinding.viewModel = mViewModel

        configRecyclerView()
        observeSources()
    }

    /**
     * Sources recyclerview configuration
     */
    private fun configRecyclerView() {
        mBinding.rvSources.layoutManager = mLayoutManager
        mBinding.rvSources.setHasFixedSize(true)
        mBinding.rvSources.adapter = mAdapter
    }

    /**
     * Observer sources response
     */
    private fun observeSources() {
        mViewModel.fetchSources().observe(this, Observer {
            if (it != null) {
                mAdapter.addSources(it)
            }
        })
    }

    /**
     * Source cell click
     */
    override fun onItemClick(source: Source) {
        toast("source id: ${source.id}")
        startActivity(intentFor<ArticlesActivity>())
    }
}
