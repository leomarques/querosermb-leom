package com.querosermb.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        ExchangeEntity::class,
    ],
    version = 1,
    exportSchema = true
)
abstract class MBDatabase : RoomDatabase() {
    abstract fun exchangeDao(): ExchangeDao

    companion object {
        @Volatile
        private var instance: MBDatabase? = null

        fun getInstance(context: Context): MBDatabase =
            instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MBDatabase::class.java,
                "mb.db"
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}
