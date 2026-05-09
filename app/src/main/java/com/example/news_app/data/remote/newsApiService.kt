package com.example.newsapp.data

import retrofit2.http.GET
import retrofit2.http.Query
import com.newsapp.data.model.Article

data class NewsResponse(
    val articles: List<Article>
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