package com.example.wonderui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.wonderUI.R
import com.example.wonderui.theme.LocalDimensions
import com.example.wonderui.theme.WonderTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun <T>WonderChipFlow(
    title: String,
    items: List<T>,
    onAddItem: () -> Unit,
    onRemoveItem: (Int, T) -> Unit,
    onClearList: () -> Unit,
    modifier: Modifier = Modifier,
){
    WonderTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.medium),
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.headlineSmall
                )
                TextButton(onClick = onClearList) {
                    Text(text = stringResource(id = R.string.clear_button_label))
                }
            }
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(LocalDimensions.current.small),
                verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.small)
            ) {
                items.forEachIndexed { index, item ->
                    WonderShip(content = item) {
                        onRemoveItem(index, item)
                    }
                }
            }
            OutlinedButton(
                onClick = onAddItem,
                modifier = Modifier.align(Alignment.End)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(LocalDimensions.current.small)
                ) {
                    Icon(imageVector = Icons.Default.Add , contentDescription = null)
                    Text(text = stringResource(id = R.string.add_button_label) )
                }
            }
        }
    }
}