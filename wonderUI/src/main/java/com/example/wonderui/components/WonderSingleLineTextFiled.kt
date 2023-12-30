package com.example.wonderui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wonderUI.R
import com.example.wonderui.theme.WonderTheme
import com.example.wonderui.utils.TextFieldState

@Composable
fun WonderSingleLineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
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
            modifier = modifier.fillMaxWidth(),
            singleLine = true,
            readOnly = readOnly,
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

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun WonderSingleLineTextFieldPreview(){
    var currentValue by remember {
        mutableStateOf("")
    }
    WonderSingleLineTextField(
        value = currentValue,
        onValueChange = { value -> currentValue = value },
        label = stringResource(id = R.string.wonder_single_line_text_filed),
    )
}
