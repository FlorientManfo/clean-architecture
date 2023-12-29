package com.example.wonderui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wonderui.theme.WonderTheme
import com.example.wonderui.utils.TextFieldState

@Composable
fun MultiLineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    maxLines: Int = 4,
    state: TextFieldState = TextFieldState.Normal,
    placeholder: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    leading: @Composable (() -> Unit)? = null,
){
    WonderTheme {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = false,
            maxLines = maxLines,
            minLines = maxLines,
            isError = state is TextFieldState.Error,
            supportingText = {
                if (state is TextFieldState.Error) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = state.message,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            placeholder = placeholder,
            trailingIcon = trailing,
            leadingIcon = leading
        )
    }
}