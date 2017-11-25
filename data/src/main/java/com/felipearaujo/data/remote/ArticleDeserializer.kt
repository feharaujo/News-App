package com.felipearaujo.data.remote

import com.felipearaujo.data.*
import com.felipearaujo.model.Article
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipearaujo on 25/11/17.
 */
class ArticleDeserializer : JsonDeserializer<Article> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Article {

        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

        val jsonObject = json?.asJsonObject
        val title: String
        title = if (jsonObject?.get(KEY_TITLE) !is JsonNull) {
            jsonObject?.get(KEY_TITLE)?.asString!!
        } else {
            ""
        }

        val description: String
        description = if (jsonObject.get(KEY_DESCRIPTION) !is JsonNull) {
            jsonObject.get(KEY_DESCRIPTION)?.asString!!
        } else {
            ""
        }

        val url: String
        url = if (jsonObject.get(KEY_URL) !is JsonNull) {
            jsonObject.get(KEY_URL)?.asString!!
        } else {
            ""
        }

        val urlToImage: String
        urlToImage = if (jsonObject.get(KEY_URL_IMAGE) !is JsonNull) {
            jsonObject.get(KEY_URL_IMAGE)?.asString!!
        } else {
            ""
        }

        val author: String
        author = if (jsonObject.get(KEY_URL_AUTHOR) !is JsonNull) {
            jsonObject.get(KEY_URL_AUTHOR)?.asString!!
        } else {
            ""
        }

        val date: Date
        date = if (jsonObject.get(KEY_URL_DATE) !is JsonNull) {
            try {
                val dateText = jsonObject.get(KEY_URL_DATE)?.asString!!
                df.parse(dateText)
            } catch (e: ParseException) {
                Date(Long.MIN_VALUE)
            }

        } else {
            Date(Long.MIN_VALUE)
        }

        return Article(
                title,
                description,
                url,
                urlToImage,
                date,
                author
        )

    }
}