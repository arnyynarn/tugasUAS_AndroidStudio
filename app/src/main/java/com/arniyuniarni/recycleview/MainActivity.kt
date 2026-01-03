package com.arniyuniarni.recycleview

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arniyuniarni.recycleview.adapter.AdapterAktor
import com.arniyuniarni.recycleview.databinding.ActivityMainBinding
import com.arniyuniarni.recycleview.model.Aktor

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listAktor = ArrayList<Aktor>()
        listAktor.add(Aktor("Lee Je-hoon", R.drawable.aktor5, "Kim do-gi", "176 cm", "Seoul, Korea Selatan", "4 Juli 1984" ))
        listAktor.add(Aktor("Kim Eui-Sung", R.drawable.aktor1, "Jang Sung-Cheol", "175 cm", "Seoul, Korea Selatan", "17 Desember 1965" ))
        listAktor.add(Aktor("Pyo Ye-Jin", R.drawable.aktor4, "Ahn Go-Eun", "164 cm", "Changwon, Korea Selatan", "5 Februari 1992" ))
        listAktor.add(Aktor("Jang Hyuk-Jin", R.drawable.aktor3, "Choi Kyung-Gu", "178 cm", "Seoul, Korea Selatan", "16 Agustus 1971" ))
        listAktor.add(Aktor("Bae Yoo-Ram", R.drawable.aktor2, "Park Jin-Eon", "176 cm", "Daegu, Korea Selatan", "22 Agustus 1986" ))

        binding.list.adapter = AdapterAktor(this, listAktor, object  : AdapterAktor.OnClickListener{
            override fun detailData(item: Aktor?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_aktor)

                    val image = this.findViewById<ImageView>(R.id.image_aktor)
                    val nama = this.findViewById<TextView>(R.id.txtNamaAktor)
                    val pemeran = this.findViewById<TextView>(R.id.txtPemeran)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTL)
                    val tanggallahir = this.findViewById<TextView>(R.id.txtTgl)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    nama.text = "${item?.pemeran}"
                    nama.text = "${item?.tinggi}"
                    nama.text = "${item?.tempatLahir}"
                    nama.text = "${item?.tglLahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }
            }

        })

    }
}