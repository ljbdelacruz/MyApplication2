package com.example.myapplication2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication2.click_counter.data.CounterDao
import com.example.myapplication2.click_counter.data.CounterEntity

@Database(entities = [CounterEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun counterDao(): CounterDao
}