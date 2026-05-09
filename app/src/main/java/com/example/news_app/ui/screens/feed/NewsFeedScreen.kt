package com.example.news_app.ui.screens.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsapp.data.RetrofitInstance
import com.newsapp.data.model.Article
import kotlinx.coroutines.launch
import com.example.news_app.ui.components.ArticleCard

@Composable
fun FeedScreen(onArticleClick: (Article) -> Unit) {
    var articles by remember {
        mutableStateOf<List<Article>>(emptyList())
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                articles = RetrofitInstance.api.getNews(
                    query = "technology",
                    apiKey = "85df1faf9a59439ead9b27ba8063d5f3"
                ).articles
            } catch (e: Exception) {
                // handle error
            }
        }
    }

    LazyColumn {
        items(articles) { article ->
            ArticleCard(
                article = article,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onArticleClick(article) }
            )
        }
    }
}