package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {

    private val countries=arrayOf("Nepal","China","India")

    private lateinit var lstView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        lstView=findViewById(R.id.listView)

        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,countries)
        lstView.adapter=adapter

        lstView.setOnItemClickListener{parent,view,position,id->
            val element=parent.getItemAtPosition(position)
            Toast.makeText(this, element.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}