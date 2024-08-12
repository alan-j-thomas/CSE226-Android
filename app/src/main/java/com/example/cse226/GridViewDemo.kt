package com.example.cse226

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GridViewDemo : AppCompatActivity() {

    lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_demo)

        gridView = findViewById(R.id.gv)
        var arr = mutableListOf<GridModelDemo>()
        arr.add(GridModelDemo("Carlos Sainz", R.drawable.f1))
        arr.add(GridModelDemo("Charles Leclerc", R.drawable.img2))
        arr.add(GridModelDemo("Lewis Hamilton", R.drawable.img3))
        arr.add(GridModelDemo("Michael Schumacher", R.drawable.img4))

        gridView.adapter = GridAdapterDemo(this, arr)
    }
}