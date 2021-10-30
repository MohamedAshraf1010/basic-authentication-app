package com.coderbot.basicauthenticationapp.presentation.login

sealed class LoginViewIntents
{
    class Login(val username: String, val password: String) : LoginViewIntents()
}