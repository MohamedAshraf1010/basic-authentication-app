package com.coderbot.basicauthenticationapp.presentation.welcome

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
import com.coderbot.basicauthenticationapp.presentation.common_views.ButtonView
import com.coderbot.basicauthenticationapp.presentation.common_views.ButtonWidth
import com.coderbot.basicauthenticationapp.presentation.common_views.ImageView
import com.coderbot.basicauthenticationapp.presentation.common_views.TextView

@Composable
fun Welcome(navController: NavHostController)
{
    WelcomeView({
        navController.navigate("login")
    }, {
        navController.navigate("signup")
    })
}

@Composable
fun WelcomeView(loginAction: () -> Unit = { }, signupAction: () -> Unit = { })
{
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier
            .weight(8f)
            .fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            ImageView(painter = painterResource(id = R.drawable.ic_logo))
            Box(modifier = Modifier.height(16.dp))
            TextView(text = stringResource(id = R.string.app_name))
        }
        Column(modifier = Modifier
            .weight(2f)
            .fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            ButtonView(label = stringResource(id = R.string.login), width = ButtonWidth.FILLED, action = loginAction)
            Box(modifier = Modifier.height(10.dp))
            ButtonView(label = stringResource(id = R.string.signup), width = ButtonWidth.FILLED, action = signupAction)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeViewPreview()
{
    WelcomeView()
}