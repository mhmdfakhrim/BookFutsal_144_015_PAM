package com.example.bookfutsal.data.rules

object ValidatorLogin {

    fun validateEmail(email: String): ValidationResultLogin {
        return ValidationResultLogin(
            (!email.isNullOrEmpty())
        )
    }

    fun validatePassword(password: String): ValidationResultLogin {
        return ValidationResultLogin(
            (!password.isNullOrEmpty() && password.length >= 4)
        )
    }
}

data class ValidationResultLogin(
    val status: Boolean = false
)