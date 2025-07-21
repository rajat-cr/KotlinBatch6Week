package com.coderroots.kotlinclass6week.practiceBottom

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.coderroots.kotlinclass6week.R
import com.coderroots.kotlinclass6week.databinding.ActivityPracticrBottomBinding

class PracticrBottom : AppCompatActivity() {
    lateinit var binding : ActivityPracticrBottomBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPracticrBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController = findNavController(R.id.navHost1)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1-> {
                    navController.navigate(R.id.firstPracticeFragment)
                }
                R.id.item2->{
                    navController.navigate(R.id.secondPracticeFragment)
                }

            }

            return@setOnItemSelectedListener true
        }

    }
}