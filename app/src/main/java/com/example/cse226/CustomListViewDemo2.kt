package com.example.cse226

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cse226.ModelDemo
import com.example.cse226.MyAdapter
import com.example.cse226.R


class CustomListViewDemo2 : AppCompatActivity() {
    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var add: Button
    private lateinit var imageView: ImageView
    private var selectedImageUri: Uri? = null
    private var PICK_IMAGE = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view_demo2)
        var listView = findViewById<ListView>(R.id.listView)
        var list = mutableListOf<ModelDemo>()
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        add = findViewById(R.id.add)
        var ad = MyAdapter(
            this, R.layout.custom_look, list
        )
        listView.adapter = ad
        imageView.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(intent, PICK_IMAGE)
        }

        add.setOnClickListener {
            selectedImageUri?.let {
                list.add(ModelDemo(et1.text.toString(), et2.text.toString(), it))
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
                ad.notifyDataSetChanged()
            } ?: run {
                Toast.makeText(this, "Please select an image first", Toast.LENGTH_SHORT).show()
            }
        }
        imageView = findViewById(R.id.img)

// listView.setOnItemClickListener { adapterView, view, i, l ->
//     list.removeAt(i)
//     ad.notifyDataSetChanged()
// }
        /*   listView.setOnItemLongClickListener { adapterView, view, i, l ->
               val b=AlertDialog.Builder(this)
               b.setTitle("Are you sure ?")
               b.setCancelable(true)
               b.setPositiveButton("Yes"){
                   a,b,->
                   list.removeAt(i)
                   ad.notifyDataSetChanged()
               }
               b.setNegativeButton("NO"){
                       a,b,->
                a.dismiss()
               }
               b.show()
               true
           }

         */

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            selectedImageUri?.let {
                val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, it)
                imageView.setImageBitmap(bitmap)
            }
        }
    }
}