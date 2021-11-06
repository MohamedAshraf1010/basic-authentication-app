package com.coderbot.basicauthenticationapp

import com.coderbot.basicauthenticationapp.data.model.User
import com.coderbot.basicauthenticationapp.domain.repository.UserRepository
import com.coderbot.basicauthenticationapp.domain.usecase.Signup
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class SignupTest
{
    private lateinit var signup: Signup
    private lateinit var repository: UserRepository

    @Before
    fun initRepository()
    {
        repository = Mockito.mock(UserRepository::class.java)
        signup = Signup(repository)
    }

    @Test
    fun testSignupProcess()
    {
        runBlocking {
            val expectedResult = User(id= "4", email = "eve.holt@reqres.in", password = "pistol", token = "QpwL5tke4Pnpja7X4")
            Mockito.`when`(repository.signup("eve.holt@reqres.in", "pistol")).thenReturn(expectedResult)

            val actualResult = signup.run("eve.holt@reqres.in", "pistol", "pistol")
            Assert.assertNotNull(actualResult.token)
            Assert.assertEquals(expectedResult.email, actualResult.email)
            Assert.assertEquals(expectedResult.password, actualResult.password)
        }
    }
}