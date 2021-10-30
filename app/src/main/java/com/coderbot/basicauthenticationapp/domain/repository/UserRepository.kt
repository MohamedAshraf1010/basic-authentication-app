package com.coderbot.basicauthenticationapp.domain.repository

import com.coderbot.basicauthenticationapp.data.model.User

interface UserRepository
{
    suspend fun login(email: String, password: String): User
}