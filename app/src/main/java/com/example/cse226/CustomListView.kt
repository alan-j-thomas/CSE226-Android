package com.example.cse226

import android.graphics.ColorSpace.Model
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomListView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_list_view)

        var listView: ListView = findViewById(R.id.listView)
        var list = mutableListOf<ModelDemo>()
//        list.add(ModelDemo("Carlos Sainz", "Ferrari", R.drawable.f1))
//        list.add(ModelDemo("Charles Leclerc", "Ferrari", R.drawable.img2))
//        list.add(ModelDemo("Lewis Hamilton", "Mercedes AMG", R.drawable.img3))
//        list.add(ModelDemo("Michael Schumacher", "Williams", R.drawable.img4))


        var ad = MyAdapter(this, R.layout.custom_look, list)
        listView.adapter = ad



//        Deleting an item when it is clicked
        listView.setOnItemClickListener { adapterView, view, i, l ->
            list.removeAt(i)
            ad.notifyDataSetChanged()
        }

        listView.setOnItemLongClickListener { adapterView, view, i, l ->

            val builder = AlertDialog.Builder(this)
            builder.setCancelable(true)
            builder.setTitle("Are you sure?")
            builder.setMessage("Do you want to delete this item?")
            builder.setPositiveButton("Yes"){dialog, which ->
                list.removeAt(i)
                ad.notifyDataSetChanged()
            }

            builder.setNegativeButton("No") { dialog, which ->
                dialog.cancel()
            }
            builder.show()


            return@setOnItemLongClickListener true
        }
    }
}