package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavController() //TODO: (12) In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration
    }

    override fun onSupportNavigateUp(): Boolean {
        val navigation = this.findNavController(R.id.myNavHostFragment)

        //TODO: (15) Make sure you can’t go back to onboarding screens In the Shoe List screen
        return if (navigation.currentDestination?.id == R.id.shoeListFragment
            || navigation.currentDestination?.id == R.id.loginFragment
        ) {
            finish()
            true
        } else {
            navigation.navigateUp()
        }
    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }
    private fun setUpNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun logout() {
        findNavController(R.id.myNavHostFragment).navigate(R.id.loginFragment)
    }
}
