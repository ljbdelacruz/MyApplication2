package com.example.myapplication2.click_counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor() : ViewModel() {
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun increment() {
        viewModelScope.launch {
            _count.value = (_count.value ?: 0) + 1
        }
    }

    fun decrement() {
        viewModelScope.launch {
            _count.value = (_count.value ?: 0) - 1
        }
    }
}

