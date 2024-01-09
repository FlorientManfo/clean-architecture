package com.wonder.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.wonder.data.dao.ExampleDao
import com.wonder.data.migrations.MigrationV0ToV1

abstract class Database : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao

    companion object {

        @Volatile
        private var instance: Database? = null

        fun getInstance(context: Context): Database {
            return instance ?: synchronized(this) {
                instance ?: build(context).also { instance = it }
            }
        }

        private fun build(context: Context): Database {
            return Room.databaseBuilder(
                context.applicationContext,
                Database::class.java,
                Constants.dbName
            ).allowMainThreadQueries()
                .addMigrations(*MIGRATIONS)
                .fallbackToDestructiveMigration()
                .build()
        }

        private val MIGRATIONS = arrayOf<Migration>(
            MigrationV0ToV1
        )
    }
}


