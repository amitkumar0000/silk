package com.silk.ui

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_header.view.*

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
            when (it.itemId) {
                R.id.nav_my_account -> {}
                R.id.nav_settings -> {}
                R.id.nav_settings -> {}
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        drawerLayout.setScrimColor(Color.TRANSPARENT)

        val headerView = nav_view.getHeaderView(0)
        headerView.profileName.text = name
        Glide.with(this)
            .load(photoUrl)
            .placeholder(R.drawable.common_full_open_on_phone)
            .error(R.drawable.common_google_signin_btn_icon_dark)
            .into(headerView.profileImageView)
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}