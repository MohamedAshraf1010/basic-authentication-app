package com.coderbot.basicauthenticationapp

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SignupTest constructor(private var input: String, private var expectedResult: String)
{
    companion object
    {
        @JvmStatic
        @Parameterized.Parameters
        fun inputs(): Collection<Any>
        {
            return arrayOf(
                arrayOf("t", "t"),
                arrayOf("t", "t"),
                arrayOf("t", "t"),
                arrayOf("t", "t"),
            ).toList()
        }
    }

    @Test
    fun testSignupProcess()
    {
        Assert.assertEquals(expectedResult, input)
    }
}