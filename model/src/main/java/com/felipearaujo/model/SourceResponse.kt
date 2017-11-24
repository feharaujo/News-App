package com.felipearaujo.model

/**
 * Created by felipearaujo on 04/11/17.
 */
data class SourceResponse(
        val sources: List<Source>?,
        @Transient val throwable: Throwable?

)