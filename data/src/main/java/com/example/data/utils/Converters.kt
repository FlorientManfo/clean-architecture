package com.example.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    inline fun <reified T> fromString(value: String): T {
        val listType = object : TypeToken<T>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun <T> fromList(list: T): String {
        return Gson().toJson(list)
    }
}