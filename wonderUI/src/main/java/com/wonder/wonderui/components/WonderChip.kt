package com.wonder.wonderui.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wonder.wonderUI.R
import com.wonder.wonderui.theme.LocalDimensions
import com.wonder.wonderui.theme.WonderTheme

@Composable
fun <T>WonderChip(
    content: T,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.primary,
    foreground: Color = MaterialTheme.colorScheme.onPrimary,
){
    WonderTheme {
        Card(
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(contentColor = foreground, containerColor = background),
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

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun WonderChipPreview(){
    WonderChip(
        content = stringResource(id = R.string.wonder_chip_review_content) ,
        onRemove = { /*TODO*/ }
    )
}