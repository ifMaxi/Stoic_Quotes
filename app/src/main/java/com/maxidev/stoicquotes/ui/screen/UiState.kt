package com.maxidev.stoicquotes.ui.screen

import com.maxidev.stoicquotes.data.model.StoicJson

sealed interface UiState {
    data class Success(val quote: StoicJson): UiState
    object Loading: UiState
    object Error: UiState
}
