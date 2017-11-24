package com.felipearaujo.newsapp.articles.list

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipearaujo on 23/11/17.
 */

@BindingAdapter("imageUrl")
fun loadImageIntoImageView(imageView: ImageView, url: String) {
    if (url.isNotEmpty()) {
        Picasso.with(imageView.context).load(url).into(imageView)
    }
}

@BindingAdapter("date")
fun formatDateIntoTextView(textView: TextView, date: Date) {
    if (date.time != Long.MIN_VALUE) {
        val dateFormat = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault())
        textView.text = dateFormat.format(date)
    }
}