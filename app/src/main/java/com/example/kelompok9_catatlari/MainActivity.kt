package com.example.kelompok9_catatlari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cukup panggil layout utamanya saja, tanpa setingan Edge-to-Edge yang rawan error
        setContentView(R.layout.activity_main)
    }
}