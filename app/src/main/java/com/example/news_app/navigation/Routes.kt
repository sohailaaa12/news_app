package com.example.news_app.navigation

object Routes {
    const val FEED = "feed"
    const val DETAIL = "detail/{articleJson}"

    fun createDetailRoute(articleJson: String): String {
        return "detail/$articleJson"
    }
}
