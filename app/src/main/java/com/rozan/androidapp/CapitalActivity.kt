package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CapitalActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capital)

        tvResult=findViewById(R.id.tvResult)

        //Receiving value from another activity

        val intent=intent

        if(intent!=null){
            val country=intent.getStringExtra("country")
            val capital=intent.getStringExtra("capital")

            tvResult.text="$country's capital is: $capital"
        }
        else{
            tvResult.text="No values received."
        }
    }
}