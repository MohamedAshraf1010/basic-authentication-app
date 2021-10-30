package com.coderbot.basicauthenticationapp.presentation.common_views

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.coderbot.basicauthenticationapp.utils.Constants

@Composable
fun ButtonView(label: String, wrap: Boolean = false, action: () -> Unit)
{
    if (wrap)
    {
        Button(modifier = Modifier
            .height(50.dp)
            .wrapContentWidth(), onClick = action) {
            Text(text = label)
        }
    }
    else
    {
        Button(modifier = Modifier
            .height(50.dp)
            .width(Constants.buttonWidth(LocalContext.current).dp), onClick = action) {
            Text(text = label)
        }
    }
}