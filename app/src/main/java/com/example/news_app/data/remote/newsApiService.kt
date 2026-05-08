package com.example.newsapp.data

import retrofit2.http.GET
import retrofit2.http.Query

data class NewsResponse(
    val articles: List<Article>
)

data class Article(
    val title: String,
    val author: String?,
    val urlToImage: String?
)

interface NewsApi {

    @GET("v2/everything")
    suspend fun getNews(

        @Query("q")
        query: String,

        @Query("apiKey")
        apiKey: String

    ): NewsResponse
}