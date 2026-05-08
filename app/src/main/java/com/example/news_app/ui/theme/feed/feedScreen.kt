package com.example.newsapp.ui.feed

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsapp.data.Article
import com.example.newsapp.data.RetrofitInstance
import kotlinx.coroutines.launch

@Composable
fun FeedScreen() {

    var articles by remember {
        mutableStateOf<List<Article>>(emptyList())
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {

        scope.launch {

            articles =
                RetrofitInstance.api.getNews(
                    query = "tesla",
                    apiKey = "85df1faf9a59439ead9b27ba8063d5f3"
                ).articles

        }

    }

    LazyColumn {

        items(articles) { article ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

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

    }

}