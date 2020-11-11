package com.example.emut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.emut.R

class Daftar : AppCompatActivity() {

    companion object{
        const val name = "a"
        const val id = "i"
        const val study = "u"
        const val address = "e"
        const val date = "o"
        const val  jenmin = "p"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        val isi_daftar : TextView = findViewById(R.id.text_daftar)

        val nama = intent.getStringExtra(name)
        val nim = intent.getIntExtra(id,0)
        val jurusan = intent.getStringExtra(study)
        val jenis_kelamin = intent.getStringExtra(jenmin)
        val tgllahir = intent.getIntExtra(date, 0)
        val alamat = intent.getStringExtra(address)
        val hasil = "Nama : $nama \nNIM : $nim \nJurusan : $jurusan \nJenis Kelamin : $jenis_kelamin \nAlamat : $alamat \nTanggal Lahir : $tgllahir "
        isi_daftar.text = hasil

    }
}