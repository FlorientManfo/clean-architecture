package com.example.wonderui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.wonderui.theme.LocalDimensions
import com.example.wonderui.theme.WonderTheme

@Composable
fun <T>WonderChip(
    content: T,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
){
    WonderTheme {
        Card(
            shape = MaterialTheme.shapes.large,
            elevation = CardDefaults.cardElevation(defaultElevation = LocalDimensions.current.small),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(LocalDimensions.current.small),
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(horizontal = LocalDimensions.current.small)
            ) {
                Text(text = content.toString())
                IconButton(onClick = { onRemove() }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                }
            }
        }
    }
}