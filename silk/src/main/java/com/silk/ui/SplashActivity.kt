package com.silk.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivityForResult(Intent(this, GoogleLoginActivity::class.java), 100)
        }, 3000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            100 -> {
                when(resultCode) {
                    Activity.RESULT_OK ->
                        startActivity(Intent(this, MainActivity::class.java))
                    Activity.RESULT_CANCELED ->
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}