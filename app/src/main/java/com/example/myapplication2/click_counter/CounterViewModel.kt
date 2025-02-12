package com.example.myapplication2.click_counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication2.click_counter.data.CounterEntity
import com.example.myapplication2.click_counter.data.CounterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(private val repository: CounterRepository) : ViewModel() {
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    init {
        viewModelScope.launch {
            val counter = repository.getCounter()
            _count.value = counter?.count ?: 0
        }
    }

    fun increment() {
        viewModelScope.launch {
            _count.value = (_count.value ?: 0) + 1
            repository.saveCounter(CounterEntity(count = _count.value ?: 0))
        }
    }

    fun decrement() {
        viewModelScope.launch {
            _count.value = (_count.value ?: 0) - 1
            repository.saveCounter(CounterEntity(count = _count.value ?: 0))
        }
    }
}

