package com.coderbot.basicauthenticationapp

import com.coderbot.basicauthenticationapp.data.model.User
import com.coderbot.basicauthenticationapp.domain.repository.UserRepository
import com.coderbot.basicauthenticationapp.domain.usecase.Login
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.Mockito

@RunWith(Parameterized::class)
class LoginTest constructor(private var input: Array<String>, private var expectedResult: User)
{
    private lateinit var login: Login
    private lateinit var repository: UserRepository

    companion object
    {
        @JvmStatic
        @Parameterized.Parameters
        fun inputs(): Collection<Any>
        {
            return arrayOf(
                arrayOf(arrayOf("m@gmail.com", "12345"), User(email = "m@gmail.com", password = "12345", token = "DSHkHDJ876DHH")),
                arrayOf(arrayOf("n@gmail.com", "45633"), User(email = "n@gmail.com", password = "45633", token = "DSHkHDJ876DHH")),
            ).toList()
        }
    }

    @Before
    fun initRepository()
    {
        repository = Mockito.mock(UserRepository::class.java)
        login = Login(repository)
    }

    @Test
    fun testLoginProcess()
    {
        runBlocking {
            Mockito.`when`(repository.login(input[0], input[1])).thenReturn(User(email = input[0], password = input[1], token = "DSHkHDJ876DHH"))

            val actualResult = login.run(input[0], input[1])
            Assert.assertNotNull(actualResult.token)
            Assert.assertEquals(expectedResult.email, actualResult.email)
            Assert.assertEquals(expectedResult.password, actualResult.password)
        }
    }
}