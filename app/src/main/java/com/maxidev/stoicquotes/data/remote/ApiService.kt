package com.maxidev.stoicquotes.data.remote

import com.maxidev.stoicquotes.data.model.StoicJson
import com.maxidev.stoicquotes.util.Constants
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.GET_STOIC_QUOTE)
    suspend fun getQuote(): StoicJson
}
