package com.example.bookfutsal.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookfutsal.data.home.HomeViewModel
import com.example.bookfutsal.halaman.HalamanHome
import com.example.bookfutsal.halaman.HalamanLogin
import com.example.bookfutsal.halaman.HalamanSignUp
import com.example.bookfutsal.halaman.HalamanTermsAndConditions
import com.example.bookfutsal.navigation.BookOnlineFutsalAppRouter
import com.example.bookfutsal.navigation.Halaman

@Composable
fun BookOnlineFutsalApp(homeViewModel: HomeViewModel = viewModel()){

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
        ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanHome)
        }

        Crossfade(targetState = BookOnlineFutsalAppRouter.currentScreen, label = "") { currentState->
            when(currentState.value){
                is Halaman.HalamanSignUp -> {
                    HalamanSignUp()
                }

                is Halaman.HalamanTermsAndConditions-> {
                    HalamanTermsAndConditions()
                }

                is Halaman.HalamanLogin -> {
                    HalamanLogin()
                }

                is Halaman.HalamanHome -> {
                    HalamanHome()
                }


            }

        }

    }
}