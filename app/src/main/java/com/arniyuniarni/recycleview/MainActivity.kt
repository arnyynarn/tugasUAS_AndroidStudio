package com.arniyuniarni.recycleview

import android.os.Bundle
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
                TODO("Not yet implemented")
            }

        })

    }
}