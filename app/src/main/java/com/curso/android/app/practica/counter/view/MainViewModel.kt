package com.curso.android.app.practica.counter.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.counter.model.Counter
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel: ViewModel() {

    // Solo queremos que se pueda leer el contador
    val counter: LiveData<Counter> get() = _counter
    // no nos interesa que se modifique por fuera del ViewModel
    private var _counter = MutableLiveData<Counter>(Counter(0, Date()))

    fun incrementCounter() {
        val next = (_counter.value?.number ?: 0) + 1
        updateCounter(next)
    }

    fun decrementCounter() {
        val next = (_counter.value?.number ?: 0) - 1
        updateCounter(next)
    }

    private fun updateCounter(next: Int) {
        viewModelScope.launch {
            _counter.value = Counter(next, Date())
        }
    }
}
