package com.curso.android.app.practica.counter.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.counter.observe(this) {
            println("Recibimos un nuevo valor de counter. $it")
            binding.counter.text = "${it.number}"
            binding.timestamp.text = "Actualizado ${it.timestamp}"
        }

        binding.incrementButton.setOnClickListener {
            mainViewModel.incrementCounter()
        }
        binding.decrementButton.setOnClickListener {
            mainViewModel.decrementCounter()
        }
    }
}
