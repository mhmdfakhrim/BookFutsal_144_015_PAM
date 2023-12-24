package com.example.bookfutsal.halaman

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookfutsal.R
import com.example.bookfutsal.komponen.HeadingTextComponent
import com.example.bookfutsal.navigation.BookOnlineFutsalAppRouter
import com.example.bookfutsal.navigation.Halaman
import com.example.bookfutsal.navigation.SystemBackButtonHandler

@Composable
fun HalamanTermsAndConditions() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {

        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
    }

    SystemBackButtonHandler {
        BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanSignUp)
    }


}

@Preview
@Composable
fun HalamanTermsAndConditionsPreview(){
    HalamanTermsAndConditions()
}