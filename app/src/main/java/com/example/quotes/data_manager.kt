package com.example.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.models.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataManager {

     var quotesList = emptyArray<Quote>()
    var isDataLoaded= mutableStateOf(false)

    fun loadJsonFromAsset(context:Context){
        val inputStream=context.assets.open("quotes.json")
        val size:Int=inputStream.available() //number of bytes that can be read
        val buffer=ByteArray(size); //create byte array of given size
        inputStream.read(buffer) //read byte from stream and store in array
        inputStream.close()
        val json=String(buffer,Charsets.UTF_8) //convert array of bytes into character set
        val gson=Gson()
//        val quoteType = object : TypeToken<ArrayList<Quote>>() {}.type
        //convert json into specified class
        // object of java class
        quotesList=gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value=true
    }
}