package com.wonder.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wonder.data.Constants

@Entity(tableName = Constants.entityExample)
data class EntityExample (
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val firstColumn: String,
    val secondColumn: Int
)