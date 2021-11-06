package com.coderbot.basicauthenticationapp.presentation.signup

import com.coderbot.basicauthenticationapp.domain.usecase.Signup
import com.coderbot.basicauthenticationapp.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupViewModel constructor(private val signup: Signup) : BaseViewModel<SignupViewState, SignupViewIntents>()
{
    init
    {
        observeIntents {
            when (it)
            {
                is SignupViewIntents.Signup -> signup(it.email, it.password, it.passwordConfirmation)
            }
        }
    }

    private fun signup(email: String, password: String, passwordConfirmation: String) = CoroutineScope(Dispatchers.IO).launch {
        state.postValue(SignupViewState.LoadingState)
        try
        {
            val user = signup.run(email, password, passwordConfirmation)
            state.postValue(SignupViewState.AuthenticatedState(user))
        }
        catch (ex: Throwable)
        {
            state.postValue(SignupViewState.ErrorState(ex))
        }
    }
}