package com.example.effectivemobileaviation.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.effectivemobileaviation.R
import com.example.effectivemobileaviation.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.rootFragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.navigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ticketsFragment -> {
                    navController.navigate(R.id.ticketsFragment)
                }

                R.id.hotelsFragment -> {
                    navController.navigate(R.id.hotelsFragment)
                }

                R.id.shortlyFragment -> {
                    navController.navigate(R.id.shortlyFragment)
                }

                R.id.subscriptionsFragment -> {
                    navController.navigate(R.id.subscriptionsFragment)
                }

                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                }
            }
            true
        }
    }
}