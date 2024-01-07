package com.example.wonderui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.wonderUI.R
import com.example.wonderui.theme.LocalDimensions
import com.example.wonderui.theme.WonderTheme
import com.example.wonderui.utils.DialogType

@Composable
fun WonderDialogBox(
    dialogType: DialogType,
    modifier: Modifier = Modifier,
    title: @Composable ((modifier: Modifier) -> Unit)? = null,
    content: @Composable ((modifier: Modifier) -> Unit)? = null,
    onDismiss: (() -> Unit)? = null,
    onConfirm: (() -> Unit)? = null,
    onCancel: (() -> Unit)? = null,
) {
    val contentModifier = modifier
        .fillMaxWidth()
        .padding(LocalDimensions.current.medium)

    val dialogProperties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true
    )
    WonderTheme {
        when (dialogType) {
            DialogType.ERROR -> {
                Dialog(
                    onDismissRequest = { onDismiss?.invoke() },
                    properties = dialogProperties
                ) {
                    Card(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(LocalDimensions.current.medium),
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        if (title == null) {
                            Text(
                                text = stringResource(id = R.string.default_dialog_error_title),
                                style = MaterialTheme.typography.headlineMedium,
                                textAlign = TextAlign.Start,
                                modifier = contentModifier
                            )
                        } else {
                            title(contentModifier)
                        }
                        if (content == null) {
                            Text(
                                text = stringResource(id = R.string.default_dialog_error_message),
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Justify,
                                modifier = contentModifier
                            )
                        } else {
                            content(contentModifier)
                        }
                        Row(
                            modifier = contentModifier,
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = { onDismiss?.invoke() }) {
                                Text(
                                    text = "Close",
                                    color = MaterialTheme.colorScheme.error,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            DialogType.CONFIRM -> {
                Dialog(
                    onDismissRequest = { onDismiss?.invoke() },
                    properties = dialogProperties
                ) {
                    Card(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(LocalDimensions.current.medium),
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        if (title == null) {
                            Text(
                                text = stringResource(id = R.string.default_dialog_confirm_title),
                                style = MaterialTheme.typography.headlineMedium,
                                textAlign = TextAlign.Start,
                                modifier = contentModifier
                            )
                        } else {
                            title(contentModifier)
                        }
                        if (content == null) {
                            Text(
                                text = stringResource(id = R.string.default_dialog_confirm_message),
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Justify,
                                modifier = contentModifier
                            )
                        } else {
                            content(contentModifier)
                        }
                        Row(
                            modifier = contentModifier,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextButton(onClick = { onConfirm?.invoke() }) {
                                Text(
                                    text = "Yes",
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }

                            TextButton(onClick = { onCancel?.invoke() }) {
                                Text(
                                    text = "No",
                                    color = MaterialTheme.colorScheme.secondary,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }

            DialogType.SUCCESS -> {
                Dialog(
                    onDismissRequest = { onDismiss?.invoke() },
                    properties = dialogProperties
                ) {
                    Card(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(LocalDimensions.current.medium),
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        if (title == null) {
                            Text(
                                text = stringResource(id = R.string.default_dialog_success_title),
                                style = MaterialTheme.typography.headlineMedium,
                                textAlign = TextAlign.Start,
                                modifier = contentModifier
                            )
                        } else {
                            title(contentModifier)
                        }
                        if (content == null) {
                            Text(
                                text = stringResource(id = R.string.default_dialog_success_message),
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Justify,
                                modifier = contentModifier
                            )
                        } else {
                            content(contentModifier)
                        }
                        Row(
                            modifier = contentModifier,
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = { onDismiss?.invoke() }) {
                                Text(
                                    text = "Ok",
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun WonderDialogBoxPreview() {
    WonderDialogBox(dialogType = DialogType.SUCCESS)
}