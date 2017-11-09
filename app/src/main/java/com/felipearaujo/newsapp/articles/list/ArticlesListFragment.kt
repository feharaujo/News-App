package com.felipearaujo.newsapp.articles.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.felipearaujo.newsapp.BaseFragment
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.articles.ArticlesViewModel
import com.felipearaujo.newsapp.articles.ArticlesViewModelFactory
import com.felipearaujo.newsapp.databinding.FragmentArticlesListBinding
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ArticlesListFragment : BaseFragment() {

    @Inject
    lateinit var mViewModelFactory: ArticlesViewModelFactory
    @Inject
    lateinit var mAdapter: ArticlesAdapter

    val mLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    val mViewModel: ArticlesViewModel by lazy {
        ViewModelProviders.of(this, mViewModelFactory).get(ArticlesViewModel::class.java)
    }

    var mBinding: FragmentArticlesListBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate<FragmentArticlesListBinding>(inflater, R.layout.fragment_articles_list, container, false)
        configRecyclerView()
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding?.viewModel = mViewModel

        // todo remove mock
        mViewModel.fetchArticles("the-next-web").observe(this, Observer {
            if (it != null) {
                mAdapter.addArticles(it)
            }
        })
    }

    private fun configRecyclerView() {
        mBinding?.rvArticles?.layoutManager = mLayoutManager
        mBinding?.rvArticles?.setHasFixedSize(true)
        mBinding?.rvArticles?.adapter = mAdapter
    }

}
