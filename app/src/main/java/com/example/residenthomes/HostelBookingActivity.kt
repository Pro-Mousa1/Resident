package com.example.residenthomes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HostelBookingActivity : AppCompatActivity() {
    lateinit var hostel:TextView
    lateinit var student:TextView
    lateinit var phone:TextView
    lateinit var room:TextView
    lateinit var entry:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hostel_booking)

        hostel = findViewById(R.id.hosteltext)
        student = findViewById(R.id.studenttext)
        phone = findViewById(R.id.phonetext)
        room = findViewById(R.id.roomtext)
        entry = findViewById(R.id.entrytext)

        // Retrieve the data from RoomBooking Activity
        val hostelname = intent.getStringExtra("hostelname")
        val studentname = intent.getStringExtra("studentname")
        var phonenumber = intent.getStringExtra("phonenumber")
        var room = intent.getStringExtra("room")
        val entrydate = intent.getStringExtra("entrydate")

        // Display the data in the HostelBooking layout
        hostel.text = "Hostel Name: $hostelname"
        student.text = "Student Name: $studentname"
        phonenumber = "Phone Number: $phonenumber"
        room = "Room: $room"
        entry.text = "Entry Date: $entrydate"

    }
}