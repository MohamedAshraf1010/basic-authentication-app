package com.coderbot.basicauthenticationapp.presentation.signup

import com.coderbot.basicauthenticationapp.data.model.User

sealed class SignupViewState
{
    class AuthenticatedState(val user: User) : SignupViewState()
    class ErrorState(val error: Throwable) : SignupViewState()
    object LoadingState : SignupViewState()
}