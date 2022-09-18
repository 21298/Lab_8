package com.example.lab_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolBarName: MaterialToolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainer_basicToolbar
        ) as NavHostFragment

        navController = navHostFragment.navController

        val appBarConfig = AppBarConfiguration(navController.graph)
        toolBarName = findViewById(R.id.toolbar_mainActivity)
        toolBarName.setupWithNavController(navController, appBarConfig)

        listenToNavGraphChanges()
    }

    private fun listenToNavGraphChanges(){
        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.detailsCharacterFragment -> {
                    toolBarName.menu.findItem(R.id.menu_itemAscendentSort).isVisible = false
                    toolBarName.menu.findItem(R.id. menu_itemDescendentSort).isVisible = false
                }
                R.id.charactersFragment->{
                    toolBarName.visibility = View.VISIBLE
                    toolBarName.menu.findItem(R.id.menu_itemAscendentSort).isVisible = true
                    toolBarName.menu.findItem(R.id.menu_itemDescendentSort).isVisible = true
                }
            }
        })
    }
}