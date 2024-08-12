package com.example.cse226

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class MyAdapter(var ctx: Context, var resources:Int, var items: MutableList<ModelDemo>)
    : ArrayAdapter<ModelDemo>(ctx, resources, items) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater:LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(resources, null)

//        view is helping to connect the resources from other file.
//        So we use "view" to get the id
        val imgView: ImageView = view.findViewById(R.id.img)
        val tv1: TextView = view.findViewById(R.id.tv1)
        val tv2: TextView = view.findViewById(R.id.tv2)
        val mItem = items[position]

//        imgView.setImageDrawable(ctx.resources.getDrawable(mItem.img))
        tv1.text = mItem.title
        tv2.text = mItem.sub
//        img, title, sub are from the "ModelDemo.kt"
        imgView.setImageURI(Uri.parse(mItem.img.toString()))

        return view
    }

}