package com.example.loginbyfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findbtn = findViewById<Button>(R.id.jaow)

        findbtn.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }


    }
}