package com.example.quotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quotes.DataManager
import com.example.quotes.R
import com.example.quotes.models.Quote
import com.google.gson.Gson


@Preview
@Composable
fun QuoteHome(navController:NavController){

    fun navigateToDetail(quote:Quote){
        val quoteJson= Gson().toJson(quote)
        navController.navigate("QuoteDetailScreen/${quote.text}/${quote.author}")
    }
    Column {
        Text(
            "Quotes App",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.open_sans)),
            modifier = Modifier
                .padding(vertical = 15.dp)
                .align(Alignment.CenterHorizontally))
        if(DataManager.isDataLoaded.value){
            LazyColumn{
                (items(DataManager.quotesList){
                        quote->
                    QuotesListItem(quote = quote) {
                      navigateToDetail(quote)
//                        navController.navigate("QuoteDetailScreen")
                    }
                })
            }
        }else{
            Text(text = "Loading")
        }

    }

}