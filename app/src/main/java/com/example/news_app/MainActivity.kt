package com.example.news_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.example.news_app.ui.detail.ArticleDetailScreen
import com.newsapp.data.model.Article
import com.newsapp.data.model.Source

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                ArticleDetailScreen(
                    article = Article(
                        title = "Breaking: OpenAI Announces GPT-5 with Revolutionary Capabilities",
                        description = "The new model shows unprecedented reasoning abilities...",
                        content = "This is the full article content. It can be quite long and will be displayed nicely with proper line spacing. You can read all the details here about the latest developments in artificial intelligence.",
                        url = "https://jamesclear.com/getting-simple",
                        urlToImage = "https://picsum.photos/id/1015/800/600",  //random image
                        publishedAt = "2025-05-08T14:30:00Z",
                        source = Source(id = null, name = "TechCrunch"),
                        author = "Sarah Chen"
                    ),
                    onBackClick = {  }
                )
            }
        }
    }
}