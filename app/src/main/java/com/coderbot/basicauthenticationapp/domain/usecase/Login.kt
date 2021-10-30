package com.coderbot.basicauthenticationapp.domain.usecase

import com.coderbot.basicauthenticationapp.domain.repository.UserRepository

class Login constructor(private val userRepository: UserRepository)
{
    suspend fun run(email: String, password: String) = userRepository.login(email, password)
}