package com.coderbot.basicauthenticationapp.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.coderbot.basicauthenticationapp.R
import com.coderbot.basicauthenticationapp.presentation.common_views.*
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel = getViewModel())
{
    val state = viewModel.state.observeAsState()
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    when (val viewState = state.value)
    {
        is LoginViewState.AuthenticatedState ->
        {
            println(viewState.user.token)
            LoginScreenView(email, password)
        }
        is LoginViewState.LoadingState -> Loading()
        is LoginViewState.ErrorState -> Error(stringResource(R.string.error))
        else -> LoginScreenView(email, password) {
            viewModel.state.value = LoginViewState.LoadingState
            viewModel.login(email.value, password.value)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenView(email: MutableState<String> = mutableStateOf(""), password: MutableState<String> = mutableStateOf(""), loginAction: () -> Unit = {})
{
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        ImageView(painter = painterResource(id = R.drawable.ic_logo))
        Box(modifier = Modifier.height(16.dp))
        TextView(text = stringResource(id = R.string.app_name))
        Box(modifier = Modifier.height(50.dp))
        InputView(input = email, label = stringResource(id = R.string.email), keyboardType = KeyboardType.Email)
        Box(modifier = Modifier.height(16.dp))
        InputView(input = password, label = stringResource(id = R.string.password), keyboardType = KeyboardType.Password)
        Box(modifier = Modifier.height(16.dp))
        ButtonView(label = stringResource(id = R.string.login), action = loginAction)
    }
}