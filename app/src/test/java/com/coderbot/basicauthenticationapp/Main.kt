package com.coderbot.basicauthenticationapp

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    LoginTest::class,
    SignupTest::class
)
class Main