package com.coderbot.basicauthenticationapp.presentation.common_views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.coderbot.basicauthenticationapp.R

@Composable
fun TextView(text: String)
{
    Text(text = text, style = TextStyle(
        color = colorResource(id = R.color.purple_200),
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold
    ))
}