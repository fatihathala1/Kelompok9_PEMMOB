package com.example.kelompok9_catatlari

import android.os.Bundle
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

        val etName = view.findViewById<EditText>(R.id.et_name)
        val etGender = view.findViewById<EditText>(R.id.et_gender)
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val etConfirmPassword = view.findViewById<EditText>(R.id.et_confirm_password) // TAMBAHAN
        val btnRegister = view.findViewById<Button>(R.id.btn_register)
        val tvLoginLink = view.findViewById<TextView>(R.id.tv_login_link)

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val gender = etGender.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim() // TAMBAHAN

            if (name.isEmpty() || gender.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Semua kolom wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi format email
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Format email salah!"
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                etConfirmPassword.error = "Password tidak cocok!"
                return@setOnClickListener
            }
            val userBaru = User(name, gender, email, password)

            Toast.makeText(requireContext(), "Selamat ${userBaru.name}, akun berhasil dibuat!", Toast.LENGTH_LONG).show()

            val bundle = Bundle()
            bundle.putString("EMAIL_DAFTAR", userBaru.email)

            findNavController().navigate(R.id.halamanLogin, bundle)
        }

        tvLoginLink.setOnClickListener {
            findNavController().navigate(R.id.halamanLogin)
        }
    }
}
