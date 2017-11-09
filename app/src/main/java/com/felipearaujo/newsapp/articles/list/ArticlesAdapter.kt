package com.felipearaujo.newsapp.articles.list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.felipearaujo.model.Article
import com.felipearaujo.newsapp.R
import com.felipearaujo.newsapp.databinding.ItemArticleBinding
import com.squareup.picasso.Picasso

/**
 * Created by felipearaujo on 08/11/17.
 */
class ArticlesAdapter(val mPicasso: Picasso) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private val mArticlesList = ArrayList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ArticlesAdapter.ArticleViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<ItemArticleBinding>(inflater, R.layout.item_article, parent, false);
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticlesAdapter.ArticleViewHolder?, position: Int) {
        val article = mArticlesList.get(position)
        holder?.bind(article)

        /*holder?.itemView?.setOnClickListener {
            mView.onItemClick(article)
        }*/
    }

    override fun getItemCount(): Int {
        return mArticlesList.size
    }

    fun addArticles(newItems: List<Article>) {
        mArticlesList.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(val itemArticleBinding: ItemArticleBinding) : RecyclerView.ViewHolder(itemArticleBinding.root) {

        fun bind(item: Article) {
            itemArticleBinding.article = item
            mPicasso.load(item.urlToImage).into(itemArticleBinding.ivImgPreview)
            itemArticleBinding.executePendingBindings()
        }

    }

}