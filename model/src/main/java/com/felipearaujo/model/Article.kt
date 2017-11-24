package com.felipearaujo.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by felipearaujo on 04/11/17.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class Article(
        val title: String?,
        val description: String?,
        val url: String?,
        val urlToImage: String?,
        val publishedAt: Date?,
        val author: String?
) : Parcelable
