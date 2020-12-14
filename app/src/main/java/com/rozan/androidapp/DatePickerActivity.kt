package com.rozan.androidapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class DatePickerActivity : AppCompatActivity() {
    private lateinit var btnCalendar:Button
    private lateinit var tvDate:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        btnCalendar=findViewById(R.id.btnCalendar)
        tvDate=findViewById(R.id.tvDate)

        btnCalendar.setOnClickListener {
            loadCalendar()
        }
    }
    private fun loadCalendar(){
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
            view,year,monthOfYear,dayOfMonth->

        tvDate.text="Selected Date: $dayOfMonth/${monthOfYear+1}/$year"
        },
        year,
        month,
        day)
        datePickerDialog.show()
    }

}