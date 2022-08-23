package ru.mikolaych.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mikolaych.kotlinproject.databinding.SecondPageBinding

class SecondPage : AppCompatActivity() {

    private var binding:SecondPageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondPageBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }
}