package com.maxidev.stoicquotes.data.remote

import com.maxidev.stoicquotes.data.repository.StoicRepository
import com.maxidev.stoicquotes.data.repository.StoicRepositoryImpl
import com.maxidev.stoicquotes.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val stoicRepository: StoicRepository
}

class DefaultAppContainer: AppContainer {
    private val stoicRetrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: ApiService by lazy {
        stoicRetrofit.create(ApiService::class.java)
    }

    override val stoicRepository: StoicRepository by lazy {
        StoicRepositoryImpl(retrofitService)
    }
}
