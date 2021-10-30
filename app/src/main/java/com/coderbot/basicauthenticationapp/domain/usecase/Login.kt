package com.coderbot.basicauthenticationapp.domain.usecase

import com.coderbot.basicauthenticationapp.data.model.User
import com.coderbot.basicauthenticationapp.domain.repository.UserRepository

class Login constructor(private val userRepository: UserRepository)
{
    suspend fun run(email: String, password: String): User
    {
        when
        {
            email.isEmpty() -> throw Throwable("Missing Email!")
            password.isEmpty() -> throw Throwable("Missing Password!")
            else -> return userRepository.login(email, password)
        }
    }
}