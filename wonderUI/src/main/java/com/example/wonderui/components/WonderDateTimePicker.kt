package com.example.wonderui.components

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateTimePicker(
    label: String,
    onValueChange: (String) -> Unit
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

    WonderSingleLineTextField(
        value = currentValue,
        onValueChange = { value ->
            currentValue = value
            onValueChange(value)
        },
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
