package com.coderbot.basicauthenticationapp.presentation.signup

sealed class SignupViewIntents
{
    class Signup(val email: String, val password: String, val passwordConfirmation: String) : SignupViewIntents()
}