package com.bokchi.ch4_jetpack_1.ch5_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface lec6_WordDAO {

    @Query("SELECT * FROM word_table")
    fun getAllData(): List<lec6_WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: lec6_WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAllData()

}