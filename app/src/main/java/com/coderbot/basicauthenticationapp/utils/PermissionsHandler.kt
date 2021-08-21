package com.coderbot.basicauthenticationapp.utils

import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

@Composable
fun requestPermissions(listener: (Boolean) -> Unit): ManagedActivityResultLauncher<Array<String>, MutableMap<String, Boolean>>
{
    return rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions())
    {
        var isGranted = true
        it.values.forEach { result ->
            isGranted = isGranted && result
        }
        listener(isGranted)
    }
}