package com.coderbot.basicauthenticationapp.domain.usecase

import com.coderbot.basicauthenticationapp.data.model.User
import com.coderbot.basicauthenticationapp.domain.repository.UserRepository

class Signup constructor(private val userRepository: UserRepository)
{
    suspend fun run(email: String, password: String, passwordConfirmation: String): User
    {
        when
        {
            email.isEmpty() -> throw Throwable("Missing Email!")
            password.isEmpty() -> throw Throwable("Missing Password!")
            passwordConfirmation.isEmpty() -> throw Throwable("Missing Password Confirmation!")
            passwordConfirmation != password -> throw Throwable("Passwords don't match!")
            else -> return userRepository.signup(email, password)
        }
    }
}