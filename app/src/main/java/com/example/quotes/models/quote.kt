package com.example.quotes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Quote (val text:String,val author:String) : Parcelable{

}