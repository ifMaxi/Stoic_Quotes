package com.maxidev.stoicquotes.data.model

import com.google.gson.annotations.SerializedName

data class StoicJson(
    @SerializedName("author")
    val author: String,
    @SerializedName("quote")
    val quote: String
)
