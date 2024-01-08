package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.Constants
import com.example.data.entities.EntityExample

@Dao
interface ExampleDao {
    @Insert(entity = EntityExample::class)
    suspend fun createExampleItem(example: EntityExample)

    @Query("SELECT * FROM ${Constants.EntityExample}")
    suspend fun getAllExample(): List<EntityExample>

    @Update(entity = EntityExample::class)
    suspend fun updateExample(example: EntityExample)

    @Delete(entity = EntityExample::class)
    suspend fun deleteExample(example: EntityExample)
}