package com.felipearaujo.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by felipearaujo on 04/11/17.
 */
data class Article(
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: Date,
        val author: String?
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readSerializable() as Date,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(title)
        writeString(description)
        writeString(url)
        writeString(urlToImage)
        writeSerializable(publishedAt)
        writeString(author)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Article> = object : Parcelable.Creator<Article> {
            override fun createFromParcel(source: Parcel): Article = Article(source)
            override fun newArray(size: Int): Array<Article?> = arrayOfNulls(size)
        }
    }
}