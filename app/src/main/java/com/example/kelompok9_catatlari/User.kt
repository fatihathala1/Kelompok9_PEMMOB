package com.example.kelompok9_catatlari

// Data class sederhana tanpa Parcelable untuk menghindari error Gradle
data class User(
    val name: String,
    val gender: String,
    val email: String,
    val password: String
)