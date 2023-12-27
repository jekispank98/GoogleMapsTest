package com.example.googlemapstest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.googlemapstest.R
import com.example.googlemapstest.databinding.ActivityMainBinding
import com.example.googlemapstest.viewmodel.LocationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<LocationViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.startGettingBackgroundJson()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = navHostFragment.navController
//        setupActionBarWithNavController(navController)

    }

    override fun onDestroy() {
        viewModel.stopGettingBackgroundJson()
        super.onDestroy()
    }
}