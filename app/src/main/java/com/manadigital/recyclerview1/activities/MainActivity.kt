package com.manadigital.recyclerview1.activities

import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.manadigital.recyclerview1.R

class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        bottomNavView = findViewById(R.id.bottom_bar)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)

        setupDrawerLayout()
    }


    private fun setupDrawerLayout() {
        val navController = navHostFragment.navController
        navigationView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = navHostFragment.navController
        return NavigationUI.navigateUp(
            navController,
            drawerLayout
        ) || super.onSupportNavigateUp()
    }

    fun changeToolbarBackground(drawableId: Int) {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setBackgroundResource(drawableId)
    }

    fun addToolbarButton() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val menuItem = toolbar.menu.add(0, R.id.fab_right, 0, "")
        val icon = ContextCompat.getDrawable(this, R.drawable.outline_mode_edit_outline_24)
        val wrappedIcon = DrawableCompat.wrap(icon!!)
        DrawableCompat.setTint(wrappedIcon, ContextCompat.getColor(this, android.R.color.black))
        val layers = arrayOf(ContextCompat.getDrawable(this, R.drawable.back_button), wrappedIcon)
        val layerDrawable = LayerDrawable(layers)
        menuItem.icon = layerDrawable
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        menuItem.setOnMenuItemClickListener {

            true
        }
    }

    fun removeToolbarButton() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.menu.removeItem(R.id.fab_right)
    }
}