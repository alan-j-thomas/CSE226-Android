package com.example.cse226

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class GridAdapterDemo(context: Context, var items: MutableList<GridModelDemo>)
    : ArrayAdapter<GridModelDemo>(context, 0, items) {

    @SuppressLint("ViewHolder", "MissingInflatedId")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//        Remember to make inflater and view
        val view = LayoutInflater.from(context).inflate(R.layout.mygridviewdemolayout, parent, false)

        val imgView: ImageView = view.findViewById(R.id.iv)
        val title: TextView = view.findViewById(R.id.textView)
        val click: Button = view.findViewById(R.id.btn)
        val mitems = items[position]

        imgView.setImageDrawable(context.resources.getDrawable(mitems.img))
        title.text = mitems.title


        return view
    }
}