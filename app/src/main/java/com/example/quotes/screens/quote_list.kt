package com.example.quotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotes.models.Quote

@Preview
@Composable
fun QuoteList(quotes:Array<Quote>){

    LazyColumn{
        (items(quotes){
            quote->
            QuotesListItem(quote = quote) {
            }
        })
    }
}