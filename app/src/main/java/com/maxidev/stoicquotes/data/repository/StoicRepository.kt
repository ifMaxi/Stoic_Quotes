package com.maxidev.stoicquotes.data.repository

import com.maxidev.stoicquotes.data.model.StoicJson

interface StoicRepository {
    suspend fun obtainQuote(): StoicJson
}
