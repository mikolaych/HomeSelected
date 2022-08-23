package ru.mikolaych.exersicecontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mikolaych.exersicecontrol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        supportFragmentManager.beginTransaction().replace(R.id.mainFrame, CatalogFragment()).commit()

        binding?.bottomNav?.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.navCatalog -> supportFragmentManager.beginTransaction().replace(R.id.mainFrame, CatalogFragment()).commit()
                R.id.navCalc -> supportFragmentManager.beginTransaction().replace(R.id.mainFrame, CalcFragment()).commit()
                R.id.navNotes -> supportFragmentManager.beginTransaction().replace(R.id.mainFrame, NotesFragment()).commit()
                R.id.navCalendar -> supportFragmentManager.beginTransaction().replace(R.id.mainFrame, CalendarFragment()).commit()
                R.id.navTimer -> supportFragmentManager.beginTransaction().replace(R.id.mainFrame, TimerFragment()).commit()


            }
            return@setOnItemSelectedListener true
        }

    }


}