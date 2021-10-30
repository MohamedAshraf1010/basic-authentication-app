package com.coderbot.basicauthenticationapp.application

import com.coderbot.basicauthenticationapp.BuildConfig
import com.coderbot.basicauthenticationapp.data.repository.*
import com.coderbot.basicauthenticationapp.domain.repository.*
import com.coderbot.basicauthenticationapp.domain.usecase.*
import com.coderbot.basicauthenticationapp.presentation.login.LoginViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val koinModule = module {
    single { provideRetrofit() }

    single { UserRepositoryImplementation(get()) as UserRepository }

    single { Login(get()) }

    viewModel { LoginViewModel(get()) }
}

fun provideRetrofit(): Retrofit
{
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build()
}