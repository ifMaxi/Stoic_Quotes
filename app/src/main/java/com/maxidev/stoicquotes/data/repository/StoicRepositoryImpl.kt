package com.maxidev.stoicquotes.data.repository

import com.maxidev.stoicquotes.data.model.StoicJson
import com.maxidev.stoicquotes.data.remote.ApiService

class StoicRepositoryImpl(
    private val api: ApiService
): StoicRepository {
    override suspend fun obtainQuote(): StoicJson =
        api.getQuote()
}
