package com.coderbot.basicauthenticationapp.presentation.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent { Application() }
    }
}

@Composable
fun Application()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash", builder = {
        // composable("splash", content = { SplashScreen(navController) })
        // composable("login", content = { LoginScreen(navController) })
        // composable("signup", content = { SignupScreen(navController) })
        // composable("home/{data}",
        //     arguments = listOf(navArgument("data", builder = {
        //         type = NavType.StringType
        //     })),
        //     content = { HomeScreen(navController, it.arguments!!.getString("data") ?: "") }
        // )
    })
}