package com.example.residenthomes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    lateinit var btnStarted:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnStarted = findViewById(R.id.mBtnStarted)

        btnStarted.setOnClickListener {
            val intent = Intent(this, DashBActivity::class.java)
            startActivity(intent)
        }
    }
}