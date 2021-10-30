package com.coderbot.basicauthenticationapp.presentation.login

import com.coderbot.basicauthenticationapp.domain.usecase.Login
import com.coderbot.basicauthenticationapp.presentation.base.BaseViewModel
import com.coderbot.basicauthenticationapp.utils.Delay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel constructor(private val login: Login) : BaseViewModel<LoginViewState, LoginViewIntents>()
{
    init
    {
        observeIntents {
            when (it)
            {
                is LoginViewIntents.Login -> login(it.username, it.password)
            }
        }
    }

    private fun login(email: String, password: String) = CoroutineScope(Dispatchers.IO).launch {
        state.postValue(LoginViewState.LoadingState)
        try
        {
            val user = login.run(email, password)
            state.postValue(LoginViewState.AuthenticatedState(user))
        }
        catch (ex: Throwable)
        {
            state.postValue(LoginViewState.ErrorState(ex))
        }
    }
}