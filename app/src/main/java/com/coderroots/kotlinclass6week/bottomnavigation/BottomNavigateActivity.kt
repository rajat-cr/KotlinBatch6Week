package com.coderroots.kotlinclass6week.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.coderroots.kotlinclass6week.R
import com.coderroots.kotlinclass6week.databinding.ActivityBottomNavigateBinding

class BottomNavigateActivity : AppCompatActivity() {
    lateinit var binding : ActivityBottomNavigateBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBottomNavigateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController = findNavController(R.id.nav1)


        binding.bottomNav.setOnItemSelectedListener{ it->
            when(it.itemId){
                R.id.itemHome->{  navController.navigate(R.id.bottomFragment) }
                R.id.itemSetting->{
                    navController.navigate(R.id.settingFragment)
                }
            }


            return@setOnItemSelectedListener true
        }






    }
}