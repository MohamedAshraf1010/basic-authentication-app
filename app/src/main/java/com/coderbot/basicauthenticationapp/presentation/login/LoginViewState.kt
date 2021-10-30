package com.coderbot.basicauthenticationapp.presentation.login

import com.coderbot.basicauthenticationapp.data.model.User

sealed class LoginViewState
{
    class AuthenticatedState(val user: User) : LoginViewState()
    object LoadingState : LoginViewState()
    object ErrorState : LoginViewState()
}