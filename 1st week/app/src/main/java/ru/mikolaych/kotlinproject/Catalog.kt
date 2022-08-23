package ru.mikolaych.kotlinproject

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mikolaych.kotlinproject.databinding.CatalogBinding
import kotlin.concurrent.timer

class Catalog : Fragment() {

    private var binding:CatalogBinding? = null

    private var timer = object : CountDownTimer(1500, 1000){
        override fun onTick(p0: Long) {
        }
        override fun onFinish() {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CatalogBinding.inflate(inflater, container, false)






        return binding?.root
    }


}