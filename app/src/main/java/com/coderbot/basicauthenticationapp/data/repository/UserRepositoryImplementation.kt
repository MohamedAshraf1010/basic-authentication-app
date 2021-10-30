package com.coderbot.basicauthenticationapp.data.repository

import com.coderbot.basicauthenticationapp.data.api.UserAPIs
import com.coderbot.basicauthenticationapp.data.api.requests.LoginRequest
import com.coderbot.basicauthenticationapp.data.model.User
import com.coderbot.basicauthenticationapp.domain.repository.UserRepository
import retrofit2.Retrofit

class UserRepositoryImplementation constructor(retrofit: Retrofit): UserRepository
{
    private val api = retrofit.create(UserAPIs::class.java)

    private var user: User? = null

    override suspend fun login(email: String, password: String): User
    {
        user = api.login(LoginRequest(email, password))
        user!!.email = email
        user!!.password = password
        return user!!
    }
}