package com.example.news_app.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.news_app.ui.screens.detail.ArticleDetailScreen
import com.example.news_app.ui.screens.feed.FeedScreen
import com.google.gson.Gson
import com.newsapp.data.model.Article

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.FEED) {
        composable(Routes.FEED) {
            FeedScreen(
                onArticleClick = { article ->
                    val json = Gson().toJson(article)
                    val encodedJson = Uri.encode(json)
                    navController.navigate(Routes.createDetailRoute(encodedJson))
                }
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("articleJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val articleJson = backStackEntry.arguments?.getString("articleJson")
            val article = Gson().fromJson(articleJson, Article::class.java)

            if (article != null) {
                ArticleDetailScreen(
                    article = article,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}
