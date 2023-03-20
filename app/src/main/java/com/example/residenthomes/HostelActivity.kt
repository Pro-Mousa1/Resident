package com.example.residenthomes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class HostelActivity : AppCompatActivity() {
    lateinit var hostelImageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hostel)
        hostelImageView = findViewById(R.id.imageView)
        var receivedImage = intent.getStringExtra("image")
        Glide.with(this).load(receivedImage).into(hostelImageView)
    }
}