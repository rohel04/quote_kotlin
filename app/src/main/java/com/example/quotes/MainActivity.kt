package com.example.quotes

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quotes.models.Quote
import com.example.quotes.screens.QuoteDetail
import com.example.quotes.screens.QuoteHome
import com.example.quotes.ui.theme.QuotesTheme
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
                DataManager.loadJsonFromAsset(applicationContext)
        }

        setContent {
           App()
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination ="QuoteListScreen") {
            composable(route = "QuoteListScreen") {
                QuoteHome(navController)
            }
            composable(route = "QuoteDetailScreen/{text}/{author}", arguments = listOf(
                navArgument("text"){
                    type= NavType.StringType
                },
                navArgument("author"){
                    type= NavType.StringType
                }
            )) {
                val text=it.arguments?.getString("text")?:""
                val author=it.arguments?.getString("author")?:""
                QuoteDetail(text = text, author = author)


            }
        }
    }
}


