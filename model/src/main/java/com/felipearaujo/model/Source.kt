package com.felipearaujo.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by felipearaujo on 04/11/17.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class Source(
        val id: String?,
        val name: String?,
        val description: String?,
        val url: String?
): Parcelable
