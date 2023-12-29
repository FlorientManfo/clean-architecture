package com.example.wonderui.utils

sealed class TextFieldState {
    data object Normal : TextFieldState()
    data class Error(val message: String) : TextFieldState()
}