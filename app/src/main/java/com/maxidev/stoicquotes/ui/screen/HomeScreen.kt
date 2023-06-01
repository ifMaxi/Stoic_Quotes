package com.maxidev.stoicquotes.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxidev.stoicquotes.data.model.StoicJson
import com.maxidev.stoicquotes.ui.screen.component.FetchQuoteButton
import com.maxidev.stoicquotes.ui.theme.StoicQuotesTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: StoicViewModel = viewModel(factory = StoicViewModel.Factory)

    TextQuote(
        modifier = modifier,
        stoicQuotes = StoicJson(
            viewModel.stoicAuthor,
            viewModel.stoicQuote
        ),
        onFetch = { viewModel.fetchAnotherQuote() }
    )
}

@Composable
fun TextQuote(
    modifier: Modifier = Modifier,
    stoicQuotes: StoicJson,
    onFetch: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stoicQuotes.author
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stoicQuotes.quote
        )
        Spacer(modifier = Modifier.weight(1f))
        FetchQuoteButton(
            onClick = onFetch
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TextQuotePreview() {
    StoicQuotesTheme {
        TextQuote(
            stoicQuotes = StoicJson(
                author = "Anon",
                quote = "Hello quotes"
            ),
            onFetch = {}
        )
    }
}
