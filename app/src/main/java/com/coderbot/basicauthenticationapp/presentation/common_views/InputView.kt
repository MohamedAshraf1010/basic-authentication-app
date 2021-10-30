package com.coderbot.basicauthenticationapp.presentation.common_views

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun InputView(input: MutableState<String>, label: String, keyboardType: KeyboardType, isOutlined: Boolean = false)
{
    if (isOutlined)
    {
        OutlinedTextField(input.value,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            placeholder = { Text(text = label) },
            label = { Text(text = label) },
            onValueChange = {
                input.value = it
        })
    }
    else
    {
        TextField(input.value,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            placeholder = { Text(text = label) },
            label = { Text(text = label) },
            onValueChange = {
                input.value = it
        })
    }
}