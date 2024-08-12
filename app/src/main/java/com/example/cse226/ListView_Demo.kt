package com.example.cse226

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListView_Demo : AppCompatActivity() {
    lateinit var lv: ListView
    lateinit var ad:ArrayAdapter<String>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_demo)

        lv = findViewById(R.id.lv)
        val arr = arrayOf("A", "B", "C", "D")
        ad = ArrayAdapter(this, R.layout.activity_list_view_demo, arr)

        lv.adapter = ad



    }


}