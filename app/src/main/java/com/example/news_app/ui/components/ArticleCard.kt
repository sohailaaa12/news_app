package com.example.news_app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.newsapp.data.model.Article

@Composable
fun ArticleCard(
    article: Article,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = article.title)

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = article.author ?: "Unknown")
        }
    }
}