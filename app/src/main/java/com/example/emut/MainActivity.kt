package com.example.emut

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.emut.R
import kotlinx.android.synthetic.main.activity_main.*

//nyoba komen
class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var editNama: EditText
    private lateinit var editNIM : EditText
    private lateinit var editJurusan: EditText
    private lateinit var editJK: RadioGroup
    private lateinit var editPerempuan: RadioButton
    private lateinit var editLaki: RadioButton
    private lateinit var editAlamat: EditText
    private lateinit var edittgllahir: EditText
    private lateinit var Klikbutton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNama = findViewById(R.id.edit_nama)
        editNIM = findViewById(R.id.edit_nim)
        editJurusan = findViewById(R.id.edit_jurusan)
        editAlamat = findViewById(R.id.edit_alamat)
        editJK = findViewById(R.id.selectjk)
        editPerempuan = findViewById(R.id.wanita)
        editLaki = findViewById(R.id.pria)
        edittgllahir = findViewById(R.id.edit_ttl)
        Klikbutton = findViewById(R.id.daftar)
        Klikbutton.setOnClickListener(this)


        editNama.addTextChangedListener(dieditaja)
        editNIM.addTextChangedListener(dieditaja)
        editJurusan.addTextChangedListener(dieditaja)
        editAlamat.addTextChangedListener(dieditaja)
        edittgllahir.addTextChangedListener(dieditaja)


        selectjk.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener { group, checkedId ->
                    val radio: RadioButton = findViewById(checkedId)
                    Toast.makeText(applicationContext," On checked change :"+ " ${radio.text}", Toast.LENGTH_SHORT).show()
                })

    }

    private val dieditaja: TextWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            val tulis_nama = editNama.text.toString().trim()
            val tulis_nim = editNIM.text.toString().trim()
            val tulis_jurusan = editJurusan.text.toString().trim()
            val tulis_ttl = edittgllahir.text.toString().trim()
            val tulis_alamat = editAlamat.text.toString().trim()

            var gender : String = "belum ada"
            var periksa = 0

            var id: Int = selectjk.checkedRadioButtonId
            if (id!=-1){
                val radio:RadioButton = findViewById(id)
                periksa = 1
            }

            val t = tulis_nama.isNotEmpty() && tulis_nim.isNotEmpty() && tulis_alamat.isNotEmpty() && tulis_jurusan.isNotEmpty() && tulis_ttl.isNotEmpty() && periksa==1 && tulis_nama!= null && tulis_nim!= null && tulis_alamat!= null && tulis_jurusan!= null && tulis_ttl!= null && periksa == 1
            if (t) {
                daftar.isEnabled = true
            }
        }
    }



    override fun onClick(v: View){
        val tulis_nama = editNama.text.toString().trim()
        val tulis_nim = editNIM.text.toString().trim()
        val tulis_jurusan = editJurusan.text.toString().trim()
        val tulis_ttl = edittgllahir.text.toString().trim()
        val tulis_alamat = editAlamat.text.toString().trim()
        var gender : String = "genderdiragukan"

        var id: Int = selectjk.checkedRadioButtonId
        if (id!=-1){
            val radio:RadioButton = findViewById(id)
            gender = radio.text.toString()

        }


        if(v.id == R.id.daftar){

            val pindah = Intent(this@MainActivity, Daftar :: class.java)
            pindah.putExtra(Daftar.name, tulis_nama)
            pindah.putExtra(Daftar.id, tulis_nim.toInt())
            pindah.putExtra(Daftar.study, tulis_jurusan)
            pindah.putExtra(Daftar.address, tulis_alamat)
            pindah.putExtra(Daftar.date, tulis_ttl.toInt())
            pindah.putExtra(Daftar.jenmin, gender)
            startActivity(pindah)

        }

    }
}