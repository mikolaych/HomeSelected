package ru.mikolaych.homeselected

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.mikolaych.homeselected.databinding.ActivityMainBinding
import ru.mikolaych.homeselected.tabs.TabCategoriesFragment
import ru.mikolaych.homeselected.tabs.TabFiltersFragment
import ru.mikolaych.homeselected.tabs.TabObjectsFragment
import ru.mikolaych.homeselected.tabs.TabPanelFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        supportFragmentManager.beginTransaction().replace(R.id.content, TabPanelFragment()).commit()

        binding?.bottomNav?.setOnNavigationItemSelectedListener(this)
        binding?.bottomNav?.selectedItemId = R.id.panelItemBottomNav

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.panelItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, TabPanelFragment()).commit()
            R.id.catalogProductsItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, TabObjectsFragment()).commit()
            R.id.catalogClothesItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, TabFiltersFragment()).commit()
//            R.id.catalogCategoriesItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, TabCategoriesFragment()).commit()
        }

        return true
    }
}