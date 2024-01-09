package com.wonder.wonderui.components

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wonder.wonderUI.R
import com.wonder.wonderui.theme.WonderTheme
import com.wonder.wonderui.utils.TextFieldState
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WonderDateTimePicker(
    label: String,
    onValueChange: (String) -> Unit,
    state: TextFieldState = TextFieldState.Normal,
) {
    val context = LocalContext.current
    val pattern = "yyyy-MM-dd HH:mm"
    val formatter = DateTimeFormatter.ofPattern(pattern)

    var localDate = LocalDateTime.now()
    var currentValue by remember {
        mutableStateOf(localDate.format(formatter))
    }

    val timePickerDialog = remember {
        TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                localDate = LocalDateTime.of(
                    LocalDate.of(localDate.year, localDate.month, localDate.dayOfMonth),
                    LocalTime.of(hourOfDay, minute)
                )
                currentValue = localDate.format(formatter)
                onValueChange(currentValue)
            },
            localDate.hour,
            localDate.minute,
            true
        )
    }

    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                localDate =
                    LocalDateTime.of(year, month + 1, dayOfMonth, localDate.hour, localDate.minute)
                currentValue = localDate.format(formatter)
                timePickerDialog.show()
            },
            localDate.year,
            localDate.monthValue - 1,
            localDate.dayOfMonth
        )
    }

    WonderTheme {
        WonderSingleLineTextField(
            value = currentValue,
            onValueChange = { value ->
                currentValue = value
                onValueChange(value)
            },
            modifier = Modifier.clickable {
                if (!datePickerDialog.isShowing) {
                    datePickerDialog.show()
                }
            },
            state = state,
            readOnly = true,
            label = label,
            trailing = {
                IconButton(onClick = {
                    if (!datePickerDialog.isShowing) {
                        datePickerDialog.show()
                    }
                }) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                }
            },
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun WonderDateTimePickerPreview() {
    Column {
        WonderDateTimePicker(
            label = stringResource(id = R.string.datetime_picker_preview_label),
            onValueChange = { _ -> }
        )
        WonderDateTimePicker(
            label = stringResource(id = R.string.datetime_picker_preview_label),
            onValueChange = { _ -> },
            state = TextFieldState.Error(stringResource(id = R.string.text_field_error_message_preview))
        )
    }
}
