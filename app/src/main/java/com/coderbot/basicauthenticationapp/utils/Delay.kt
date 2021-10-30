package com.coderbot.basicauthenticationapp.utils

import kotlinx.coroutines.*

object Delay
{
    fun run(duration: Long, action: () -> Unit){
        runBlocking {
            delay(duration)
            action()
        }
    }
}