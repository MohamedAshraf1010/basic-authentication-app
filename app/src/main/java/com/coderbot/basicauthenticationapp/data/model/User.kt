package com.coderbot.basicauthenticationapp.data.model

import com.google.gson.annotations.SerializedName

data class User(
     @SerializedName("id") var id: String = "",
     @SerializedName("email") var email: String = "",
     @SerializedName("token") var token: String = "",
     @SerializedName("password") var password: String = ""
)