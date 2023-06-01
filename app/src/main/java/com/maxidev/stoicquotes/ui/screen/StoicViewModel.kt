package com.maxidev.stoicquotes.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.maxidev.stoicquotes.StoicQuoteApplication
import com.maxidev.stoicquotes.data.repository.StoicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StoicViewModel(
    private val repository: StoicRepository
): ViewModel() {
    /*
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set
     */

    var stoicQuote by mutableStateOf("")
    var stoicAuthor by mutableStateOf("")

    init {
        fetchAnotherQuote()
    }

    fun fetchAnotherQuote() {
        viewModelScope.launch {
            val quote = withContext(Dispatchers.IO) {
                repository.obtainQuote()
            }
            stoicQuote = quote.quote
            stoicAuthor = quote.author
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as StoicQuoteApplication)
                val repo = application.container.stoicRepository
                StoicViewModel(repo)
            }
        }
    }
}
