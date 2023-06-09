package com.maxidev.stoicquotes.ui.screen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxidev.stoicquotes.R
import com.maxidev.stoicquotes.ui.theme.StoicQuotesTheme

@Composable
fun FetchQuoteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        onClick = onClick,
        elevation = ButtonDefaults.buttonElevation()
    ) {
        Text(
            text = stringResource(id = R.string.another_quote),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun ButtonPreview() {
    StoicQuotesTheme {
        FetchQuoteButton(onClick = {})
    }
}
