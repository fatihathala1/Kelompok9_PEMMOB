package com.example.kelompok9_catatlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class HalamanFormLari : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form_lari, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi View berdasarkan ID di XML-mu
        val etTanggal = view.findViewById<EditText>(R.id.et_tanggal)
        val etJarak = view.findViewById<EditText>(R.id.et_jarak)
        val etDurasi = view.findViewById<EditText>(R.id.et_durasi)
        val btnSave = view.findViewById<Button>(R.id.btn_save)

        // 2. Logika saat tombol Save ditekan
        btnSave.setOnClickListener {
            val tanggal = etTanggal.text.toString().trim()
            val jarak = etJarak.text.toString().trim()
            val durasi = etDurasi.text.toString().trim()

            // Validasi sederhana: pastikan tidak ada yang kosong
            if (tanggal.isEmpty() || jarak.isEmpty() || durasi.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3. Bungkus data ke dalam Data Class
            val dataLari = CatatanLari(tanggal, jarak, durasi)

            // Tampilkan pesan konfirmasi (mengambil data dari object dataLari)
            Toast.makeText(requireContext(), "Data lari tanggal ${dataLari.tanggal} tersimpan!", Toast.LENGTH_LONG).show()

            // 4. Kembali ke halaman Beranda
            findNavController().popBackStack()
        }
    }
}