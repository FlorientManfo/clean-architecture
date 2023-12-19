package com.example.wonderui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.wonderui.theme.WonderTheme

@Composable
fun WonderTextField(){
    var currentValue by remember {
        mutableStateOf("")
    }
    WonderTheme{
        Row {
            BasicTextField(
                value = currentValue,
                onValueChange = {
                    currentValue = it
                }
            ){
                Text(text = "Type something...")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WonderTextFieldPreview(){
    WonderTextField()
}