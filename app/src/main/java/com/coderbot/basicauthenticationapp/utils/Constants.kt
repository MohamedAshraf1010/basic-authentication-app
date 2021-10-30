package com.coderbot.basicauthenticationapp.utils

import android.content.Context

object Constants
{
    fun buttonWidth(context: Context): Double{
        val displayMetrics = context.resources.displayMetrics
        return displayMetrics.widthPixels * 0.195
    }
}