package com.rozan.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class CountryActivity : AppCompatActivity() {
    private val countries=arrayOf(
        "Nepal","Kathmandu",
        "China","Beijing",
        "India","New Delhi",
        "Japan","Tokyo")
    private lateinit var listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        listView=findViewById(R.id.listview)

        val capital= mutableMapOf<String,String>()

        for (i in countries.indices step 2){
            capital[countries[i]]=countries[i+1]
        }

        //Adapter
        val adapter= ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            capital.keys.toTypedArray()
        )
        listView.adapter=adapter

        //Item Click Listener

        listView.setOnItemClickListener{parent,view,position,id->

            val country=parent.getItemAtPosition(position).toString()
            val capital=capital[country]!!.toString()
            Toast.makeText(this,"The capital of $country is $capital", Toast.LENGTH_SHORT).show()

            val intent= Intent(this,CapitalActivity::class.java)
            intent.putExtra("country",country)
            intent.putExtra("capital",capital)
            startActivity(intent)
        }
    }
}