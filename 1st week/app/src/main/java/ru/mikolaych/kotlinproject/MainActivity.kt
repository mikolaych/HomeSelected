package ru.mikolaych.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import ru.mikolaych.kotlinproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null

    private var numberScore:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportFragmentManager.beginTransaction().replace(R.id.frame, Catalog()).commit()

    }

    

    private fun start(){

    }



    private var timer = object : CountDownTimer(1500, 1000){
        override fun onTick(p0: Long) {
        }
        override fun onFinish() {

        }
    }

}