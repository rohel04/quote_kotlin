package com.example.quotes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.R
import com.example.quotes.models.Quote
import com.google.gson.Gson

@Composable
fun QuotesListItem(quote: Quote,onClick:()->Unit){

    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier.clickable { onClick() }.padding(10.dp)

    ) {
        Row(
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)
        ) {
            Image(
               imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180F)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Column(
                modifier=Modifier.weight(1f)
            ) {
                Text(text = quote.text,fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.open_sans)))
                Box(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .fillMaxWidth(.4F)
                        .height(1.dp)
                        .background(Color(0xFFEEEEEE))

                )
                Text(text = quote.author,
                    fontWeight = FontWeight.Thin,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.open_sans)))

            }

        }
    }
}


