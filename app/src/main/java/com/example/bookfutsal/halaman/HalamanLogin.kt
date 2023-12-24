package com.example.bookfutsal.halaman

import androidx.compose.material.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.bookfutsal.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookfutsal.data.login.LoginViewModel
import com.example.bookfutsal.komponen.ButtonComponent
import com.example.bookfutsal.komponen.ClickableLoginTextComponent
import com.example.bookfutsal.komponen.DividerTextComponent
import com.example.bookfutsal.komponen.HeadingTextComponent
import com.example.bookfutsal.komponen.MyTextFieldComponent
import com.example.bookfutsal.komponen.NormalTextComponent
import com.example.bookfutsal.komponen.PasswordTextFieldComponent
import com.example.bookfutsal.komponen.UnderlinedTextComponent
import com.example.bookfutsal.navigation.BookOnlineFutsalAppRouter
import com.example.bookfutsal.navigation.Halaman
import com.example.bookfutsal.navigation.SystemBackButtonHandler
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HalamanLogin(loginViewModel: LoginViewModel = viewModel()){
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier
            .fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(labelValue = stringResource(id = R.string.email),
                painterResource(id = R.drawable.baseline_email_24)
            )
            PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password),
                painterResource(id = R.drawable.baseline_lock_24)
            )
            
            Spacer(modifier = Modifier.height(40.dp))
            UnderlinedTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login), onButtonClicked = { /*TODO*/ })

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanSignUp)
            })
        }


    }

    SystemBackButtonHandler {
        BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanSignUp)
    }
}

@Preview
@Composable
fun HalamanLoginPreview(){
    HalamanLogin()
}