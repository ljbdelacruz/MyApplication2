package com.example.myapplication2.click_counter.data

import com.example.myapplication2.click_counter.data.CounterDao
import javax.inject.Inject

class CounterRepository @Inject constructor(
    private val counterDao: CounterDao
) {
    suspend fun getCounter(): CounterEntity? {
        return counterDao.getCounter()
    }

    suspend fun saveCounter(counter: CounterEntity) {
        counterDao.saveCounter(counter)
    }
}