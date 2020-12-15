package com.rozan.androidapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import java.text.SimpleDateFormat
import java.util.*

class DateCalculateCalendarActivity : AppCompatActivity() {
    private lateinit var etJoinDate:EditText
    private lateinit var etDOB:EditText

    private lateinit var tvYears:TextView
    private lateinit var tvAge:TextView

    val calendar=Calendar.getInstance()
    val year=calendar.get(Calendar.YEAR)
    val month=calendar.get(Calendar.MONTH)
    val day=calendar.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_calculate_calendar)

        etJoinDate=findViewById(R.id.etJoinDate)
        etDOB=findViewById(R.id.etDOB)
        tvYears=findViewById(R.id.tvYears)
        tvAge=findViewById(R.id.tvAge)

        etJoinDate.setOnClickListener{
            loadCalendar()
        }
        etDOB.setOnClickListener{
            loadAge()
        }

    }

    private fun loadCalendar(){


        val datePickerDialog1=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
            view,years,months,days->
          etJoinDate.setText("$days/${months+1}/$years")
            var newDay=day-days
            var newMonth=(month+1)-(months+1)
            var newYear=year-years

            if(newMonth==0){
                tvYears.text="Experience: $newYear "+ "years "
            }
            else if(newYear==0){
                tvYears.text="Experience: "+ "$newMonth " + "months"
            }
            else
            tvYears.text="Experience: $newYear "+ "years "+ "$newMonth " + "months"


        },
            2015,
            0,
            1
        )
        datePickerDialog1.show()

    }
    private fun calculateJoinDate(tvYears:TextView){
//        var today=Date()
//        var dobs=etJoinDate.text.toString()
//        var sdf=SimpleDateFormat("dd/mm/yyyy")
//        var experience=sdf.parse(dobs)


    }

    private fun loadAge(){

        val datePickerDialog=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
                view,years,months,days->
            etDOB.setText("$days/${months+1}/$years")

            var newDay=day-days
            var newMonth=(month+1)-(months+1)
            var newYear=year-years

            if (newMonth==0){
                tvAge.text="Age: $newYear "+ "years "
            }
            else if(newYear==0){
                tvAge.text="Age: $newMonth " + "months"
            }
            else
            tvAge.text="Age: $newYear "+ "years "+ "$newMonth " + "months"
        },
            2000,
            0,
            1
        )
        datePickerDialog.show()


    }

}