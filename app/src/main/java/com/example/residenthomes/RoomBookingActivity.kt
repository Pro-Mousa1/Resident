package com.example.residenthomes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RoomBookingActivity : AppCompatActivity() {
    lateinit var HostelName:EditText
    lateinit var StudentName:EditText
    lateinit var PhoneNumber:EditText
    lateinit var EntryDate:EditText
    lateinit var Room:AutoCompleteTextView
    lateinit var btnBook:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_booking)

        HostelName = findViewById(R.id.mEditHostelName)
        StudentName = findViewById(R.id.mEditStudentName)
        PhoneNumber = findViewById(R.id.mEditPhoneNumber)
        Room = findViewById(R.id.auto_complete)
        EntryDate = findViewById(R.id.mEditEntryDate)
        btnBook = findViewById(R.id.mBtnBook)


        // Set OnClickListener to Book Now Button
        btnBook.setOnClickListener {
            val hostelname = HostelName.text.toString().trim()
            val studentname = StudentName.text.toString().trim()
            val phonenumber = PhoneNumber.text.toString().trim()
            val room = Room.text.toString().trim()
            val entrydate = EntryDate.text.toString().trim()

            if (hostelname.isNotEmpty() || studentname.isNotEmpty() || phonenumber.isNotEmpty() || entrydate.isNotEmpty() || room.isNotEmpty()){
                val intent = Intent(this,HostelBookingActivity::class.java)
                intent.putExtra("hostelname", hostelname)
                intent.putExtra("studentname", studentname)
                intent.putExtra("phonenumber", phonenumber)
                intent.putExtra("room", room)
                intent.putExtra("entrydate", entrydate)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please fill all the fields",
                    Toast.LENGTH_SHORT).show()
            }
        }

        val rooms = listOf("1","2","4","6","8","10")
        val autocomplete : AutoCompleteTextView = findViewById(R.id.auto_complete)
        val adapter = ArrayAdapter(this, R.layout.rooms_item,rooms)

        autocomplete.setAdapter(adapter)

        autocomplete.onItemClickListener = AdapterView.OnItemClickListener {
                adaperView, view, i, l ->

            val itemSelected = adaperView.getItemAtPosition(i)
            Toast.makeText(this, "$itemSelected:Sharing",Toast.LENGTH_SHORT).show()
        }
    }
}