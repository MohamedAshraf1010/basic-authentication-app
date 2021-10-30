package com.coderbot.basicauthenticationapp.presentation.login

import com.coderbot.basicauthenticationapp.domain.usecase.Login
import com.coderbot.basicauthenticationapp.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel constructor(private val login: Login) : BaseViewModel<LoginViewState>()
{
    fun login(email: String, password: String) = CoroutineScope(Dispatchers.IO).launch {
        try
        {
            val user = login.run(email, password)
            state.postValue(LoginViewState.AuthenticatedState(user))
        }
        catch (ex: Exception)
        {
            state.postValue(LoginViewState.ErrorState)
        }
    }
}