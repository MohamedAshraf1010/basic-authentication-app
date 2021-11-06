package com.coderbot.basicauthenticationapp.presentation.login

sealed class LoginViewIntents
{
    class Login(val email: String, val password: String) : LoginViewIntents()
}