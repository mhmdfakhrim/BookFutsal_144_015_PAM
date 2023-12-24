package com.example.bookfutsal

import android.app.Application
import com.google.firebase.FirebaseApp

class FutsalApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}