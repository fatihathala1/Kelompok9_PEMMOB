package com.example.kelompok9_catatlari

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class fragment_register : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi sesuai ID di XML-mu
        val etName = view.findViewById<EditText>(R.id.et_name)
        val etGender = view.findViewById<EditText>(R.id.et_gender)
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val btnRegister = view.findViewById<Button>(R.id.btn_register)
        val tvLoginLink = view.findViewById<TextView>(R.id.tv_login_link)

        // 2. Logika Tombol Daftar
        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val gender = etGender.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // --- VALIDASI (Sama seperti sebelumnya) ---
            if (name.isEmpty() || gender.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Semua kolom wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Format email salah!"
                return@setOnClickListener
            }

            // --- MEMBUNGKUS DATA KE DATA CLASS ---
            // Di sini kita buat objek 'userBaru' dari class User
            val userBaru = User(name, gender, email, password)

            // --- EKSEKUSI ---
            // Untuk sekarang, kita tampilkan Toast bahwa user berhasil dibuat
            Toast.makeText(requireContext(), "Selamat ${userBaru.name}, akun berhasil dibuat!", Toast.LENGTH_LONG).show()

            // Kirim data email ke halaman Login (opsional, biar user tinggal isi password)
            val bundle = Bundle()
            bundle.putString("EMAIL_DAFTAR", userBaru.email)

            // Berpindah ke Halaman Login
            findNavController().navigate(R.id.halamanLogin, bundle)
        }

        // 3. Logika Link ke Login
        tvLoginLink.setOnClickListener {
            findNavController().navigate(R.id.halamanLogin)
        }
    }
}