package com.coderbot.basicauthenticationapp.data.api

import com.coderbot.basicauthenticationapp.data.api.requests.LoginRequest
import com.coderbot.basicauthenticationapp.data.model.User
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserAPIs
{
    @Headers("Content-Type: application/json")
    // @Headers("Content-Type: application/form-url-encoded")
    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
        // @Field("email") email: String,
        // @Field("password") password: String,
    ): User
}