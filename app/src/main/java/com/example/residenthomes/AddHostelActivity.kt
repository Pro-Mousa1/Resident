package com.example.residenthomes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class AddHostelActivity : AppCompatActivity() {
    lateinit var imgUpload:ImageView
    lateinit var btnUpload:Button
    private var imageReference = Firebase.storage.reference
    private var currentFile:Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_hostel)
        imgUpload = findViewById(R.id.mImgUpload)
        btnUpload = findViewById(R.id.mBtnUpload)

        imgUpload.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also{
                it.type ="image/*"
                imageLauncher.launch(it)
            }
        }
        btnUpload.setOnClickListener {
            uploadImageToStorage("1")
        }

    }
    private val imageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == RESULT_OK){
            result?.data?.data?.let {
                currentFile = it
                imgUpload.setImageURI(it)
            }
        }else{
            Toast.makeText(this, "Canceled",Toast.LENGTH_SHORT).show()
        }
    }
    private fun uploadImageToStorage(filename:String){
        try {
            currentFile?.let {
                imageReference.child("images/$filename").putFile(it).addOnSuccessListener {
                    Toast.makeText(this, "Upload success!!",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this, "Upload failed",Toast.LENGTH_SHORT).show()

                }
            }
        }catch (e:Exception){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show()
        }
    }

}