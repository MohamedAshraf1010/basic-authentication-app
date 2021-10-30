package com.coderbot.basicauthenticationapp

import com.coderbot.basicauthenticationapp.domain.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class BaseTest
{
    private lateinit var repository: UserRepository

    @Before
    fun init()
    {
        repository = Mockito.mock(UserRepository::class.java)
    }

    @Test
    fun test()
    {
        runBlocking {

        }
    }
}