package com.bokchi.ch4_jetpack_1.ch5_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface lec4_TextDAO {
    @Query("SELECT * FROM text_table")
    fun getAllData(): List<lec4_TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: lec4_TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}