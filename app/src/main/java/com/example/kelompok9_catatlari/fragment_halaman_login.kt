package com.example.kelompok9_catatlari

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class fragment_halaman_login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_halaman_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menyambungkan variabel dengan ID di desain XML
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val btnLogin = view.findViewById<Button>(R.id.btn_register)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // --- LOGIKA VALIDASI MULAI ---
            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong!"
                return@setOnClickListener // Menghentikan proses jika kosong
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Format email salah!"
                return@setOnClickListener // Menghentikan proses jika format salah
            }
            if (password.isEmpty() || password.length < 6) {
                etPassword.error = "Password minimal 6 karakter!"
                return@setOnClickListener // Menghentikan proses jika password kurang dari 6 huruf
            }
            // --- LOGIKA VALIDASI SELESAI ---

            // Jika semua validasi di atas lolos, kode di bawah ini akan dijalankan
            // GANTI DENGAN KODE INI:
            val intent = Intent(requireActivity(), MainActivity::class.java)
            intent.putExtra("EXTRA_EMAIL", email) // Kirim email sebagai String biasa
            startActivity(intent)

            // Menutup halaman login agar tidak bisa di-back
            requireActivity().finish()
        }
    }
}