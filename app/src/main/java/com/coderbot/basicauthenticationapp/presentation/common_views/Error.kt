package com.coderbot.basicauthenticationapp.presentation.common_views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Error(error: String)
{
    Snackbar(
        action = {},
        modifier = Modifier.padding(16.dp)
    ) { Text(text = error) }
}