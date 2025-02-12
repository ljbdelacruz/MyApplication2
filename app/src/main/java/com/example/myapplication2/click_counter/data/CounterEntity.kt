package com.example.myapplication2.click_counter.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter")
data class CounterEntity(
    @PrimaryKey val id: Int = 0,
    val count: Int
)