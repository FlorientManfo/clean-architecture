package com.example.wonderui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.example.wonderui.theme.LocalDimensions
import com.example.wonderui.theme.WonderTheme

@Composable
fun WonderMultilineTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    hintText: String = "",
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    maxLines: Int = 4
){

    WonderTheme {
        Row(modifier = modifier) {
            BasicTextField(
                value,
                onValueChanged,
                textStyle = textStyle,
                maxLines = maxLines,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = modifier
                            .padding(LocalDimensions.current.paddingSmall)
                    ) {
                        if (value.isEmpty()){
                            Text(
                                text = hintText,
                                color = LocalContentColor.current.copy(alpha = 0.5f)
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WonderMultilineTextFieldPreview(){
    var currentValue by remember {
        mutableStateOf("")
    }
    WonderMultilineTextField(
        value = currentValue ,
        onValueChanged = {value -> currentValue = value},
        hintText = "Type something..."
    )
}