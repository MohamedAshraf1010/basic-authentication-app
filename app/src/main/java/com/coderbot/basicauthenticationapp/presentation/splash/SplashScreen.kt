package com.coderbot.basicauthenticationapp.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.coderbot.basicauthenticationapp.R
import com.coderbot.basicauthenticationapp.presentation.common_views.ImageView
import com.coderbot.basicauthenticationapp.presentation.common_views.TextView
import com.coderbot.basicauthenticationapp.utils.Delay

@Composable
fun SplashScreen(navController: NavHostController)
{
    SplashScreenView()
    Delay.run(5000) {
        navController.popBackStack()
        navController.navigate("login")
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenView()
{
    Column(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        ImageView(painter = painterResource(id = R.drawable.ic_logo))
        Box(modifier = Modifier.height(16.dp))
        TextView(text = stringResource(id = R.string.app_name))
    }
}