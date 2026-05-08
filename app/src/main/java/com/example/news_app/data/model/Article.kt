// data/model/Article.kt
package com.newsapp.data.model

data class Article(
    val title: String,
    val description: String?,
    val content: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val author: String?,
    val source: Source?
)

data class Source(
    val id: String?,
    val name: String?
)