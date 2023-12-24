package com.example.bookfutsal.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Halaman {
    object HalamanSignUp : Halaman()
    object HalamanTermsAndConditions : Halaman()
    object HalamanLogin : Halaman()
    object HalamanHome : Halaman()
}

object BookOnlineFutsalAppRouter {
    var currentScreen: MutableState<Halaman> = mutableStateOf(Halaman.HalamanSignUp)

    fun navigateTo(destination : Halaman){
        currentScreen.value = destination
    }
}