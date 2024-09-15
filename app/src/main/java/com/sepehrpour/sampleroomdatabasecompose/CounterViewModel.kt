package com.sepehrpour.sampleroomdatabasecompose

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val counterDao: CounterDao
) : ViewModel() {
    val counter: LiveData<CounterEntity?> = counterDao.getCounter().asLiveData()

    fun increaseCounter() {
        viewModelScope.launch {
            val currentValue = counter.value?.value ?: 0
            counterDao.insertCounter(CounterEntity(0, currentValue + 1))
        }
    }

    fun decreaseCounter() {
        viewModelScope.launch {
            val currentValue = counter.value?.value ?: 0
            if (currentValue > 0) {
                counterDao.insertCounter(CounterEntity(0, currentValue - 1))
            }
        }
    }
}