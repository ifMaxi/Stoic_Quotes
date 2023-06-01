package com.maxidev.stoicquotes

import android.app.Application
import com.maxidev.stoicquotes.data.remote.AppContainer
import com.maxidev.stoicquotes.data.remote.DefaultAppContainer

class StoicQuoteApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
