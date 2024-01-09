package com.wonder.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.wonder.data.Constants
import com.wonder.data.entities.EntityExample

@Dao
interface ExampleDao {
    @Insert(entity = EntityExample::class)
    suspend fun createExampleItem(example: EntityExample)

    @Query("SELECT * FROM ${Constants.entityExample}")
    suspend fun getAllExample(): List<EntityExample>

    @Update(entity = EntityExample::class)
    suspend fun updateExample(example: EntityExample)

    @Delete(entity = EntityExample::class)
    suspend fun deleteExample(example: EntityExample)
}