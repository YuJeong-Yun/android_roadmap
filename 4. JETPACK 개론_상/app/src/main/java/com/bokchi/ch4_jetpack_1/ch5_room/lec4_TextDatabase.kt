package com.bokchi.ch4_jetpack_1.ch5_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [lec4_TextEntity::class], version = 1)
abstract class lec4_TextDatabase : RoomDatabase() {

    abstract fun textDao(): lec4_TextDAO

    companion object {
        @Volatile
        private var INSTANCE: lec4_TextDatabase? = null

        fun getDatabase(
            context: Context
        ): lec4_TextDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    lec4_TextDatabase::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}