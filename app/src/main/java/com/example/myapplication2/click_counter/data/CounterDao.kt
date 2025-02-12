package com.example.myapplication2.click_counter.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication2.click_counter.data.CounterEntity

@Dao
interface CounterDao {
    @Query("SELECT * FROM counter WHERE id = 0")
    suspend fun getCounter(): CounterEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCounter(counter: CounterEntity)
}