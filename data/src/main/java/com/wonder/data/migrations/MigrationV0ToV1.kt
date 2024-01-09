package com.wonder.data.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wonder.data.Constants

object MigrationV0ToV1: Migration(0, 1) {
    override fun migrate(db: SupportSQLiteDatabase) {
        with(db){
            execSQL(
                "CREATE TABLE IF NOT EXISTS `${Constants.entityExample}` (`id` INTEGER NOT NULL, `firstField` TEXT NOT NULL, `secondField` INTEGER NOT NULL, PRIMARY KEY id"
            )
        }
    }
}