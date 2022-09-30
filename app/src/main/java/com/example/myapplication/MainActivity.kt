package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_background))

        Toast.makeText(applicationContext,"Hello World",Toast.LENGTH_SHORT).show()

        if (BuildConfig.DEBUG) {
            Log.v("MainActivity","Hello World")
        }
    }
}