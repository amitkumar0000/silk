package com.silk.ui

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent?.getStringExtra("ACCOUNT_NAME")
        val photoUrl = intent?.getStringExtra("ACCOUNT_PHOTO_URL")

        setSupportActionBar(toolbar)
        nav_view.bringToFront()
        var toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.nav_app_bar_open_drawer_description, R.string.nav_app_bar_open_drawer_description)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener {
            true
        }

        drawerLayout.setScrimColor(Color.TRANSPARENT);
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}