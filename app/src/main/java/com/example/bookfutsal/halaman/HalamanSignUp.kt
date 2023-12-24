package com.example.bookfutsal.halaman

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookfutsal.R
import com.example.bookfutsal.data.signup.SignupUIEvent
import com.example.bookfutsal.data.signup.SignupViewModel
import com.example.bookfutsal.komponen.ButtonComponent
import com.example.bookfutsal.komponen.CheckboxComponent
import com.example.bookfutsal.komponen.ClickableLoginTextComponent
import com.example.bookfutsal.komponen.DividerTextComponent
import com.example.bookfutsal.komponen.HeadingTextComponent
import com.example.bookfutsal.komponen.MyTextFieldComponent
import com.example.bookfutsal.komponen.NormalTextComponent
import com.example.bookfutsal.komponen.PasswordTextFieldComponent
import com.example.bookfutsal.navigation.BookOnlineFutsalAppRouter
import com.example.bookfutsal.navigation.Halaman

@Composable
fun HalamanSignUp(signupViewModel: SignupViewModel = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.create_account))
                Spacer(modifier = Modifier.height(20.dp))

                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.first_name),
                    painterResource(id = R.drawable.baseline_person_2_24),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
                )
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.last_name),
                    painterResource(id = R.drawable.baseline_person_2_24),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
                )
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource(id = R.drawable.baseline_email_24),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError
                )
                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource(id = R.drawable.baseline_lock_24),
                    onTextSelected = {
                        signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError
                )
                CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
                    onTextSelected = {
                        BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanTermsAndConditions)
                    },
                    onCheckedChange = {
                        signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                    )

                Spacer(modifier = Modifier.height(80.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.register),
                    onButtonClicked = {
                        signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                    },
                    isEnabled = signupViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanLogin)
                })
                }
            }
            if (signupViewModel.signUpInProgress.value) {
                CircularProgressIndicator()
        }

    }
}

@Preview
@Composable
fun DefaultPreviewOfHalamanSignUp(){
    HalamanSignUp()
}