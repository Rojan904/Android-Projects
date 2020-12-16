package com.rozan.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class DashBoardActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnListView:Button
    private lateinit var btnCountries:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        btnListView=findViewById(R.id.btnListView)
        btnCountries=findViewById(R.id.btnCountry)

        btnListView.setOnClickListener(this)
        btnCountries.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnListView-> {
//                Toast.makeText(this, "ListView", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ListViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btnCountry->{
                val intent = Intent(this, CountryActivity::class.java)
                startActivity(intent)
            }

        }
    }
}