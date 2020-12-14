package com.rozan.androidapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TimePickerActivity : AppCompatActivity() {
    private lateinit var btnTimePicker:Button
    private lateinit var tvTime:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        btnTimePicker=findViewById(R.id.btnTimePicker)
        tvTime=findViewById(R.id.tvTime)

        btnTimePicker.setOnClickListener {
            val c= Calendar.getInstance()
            val hour=c.get(Calendar.HOUR_OF_DAY)
            val min=c.get(Calendar.MINUTE)
//            val sec=c.get(Calendar.SECOND)
            val timePickerDialog=TimePickerDialog(this,TimePickerDialog.OnTimeSetListener {
                 timePicker, hours, minute ->
                hourFormat(hours,minute)
//                tvTime.text="Selected Time: $hours:$minute"
            },
                hour,
                min,
                false

            )
            timePickerDialog.show()
        }

    }
    private fun hourFormat(hours:Int,minute:Int){
        var am_pm="AM"
        var forthDigit = ""
        var hour=hours
        var minute=minute
      if(hour>=12){
          am_pm="PM"
          if(hour>=13 && hour<24){
              hour-=12
          }
          else{
              hour=12
          }
      }
        else if(hour==0){
          hour=12
      }
        if (minute < 10) {
            forthDigit = "0"
        }
        tvTime.text="$hour:${forthDigit+minute} $am_pm"


    }
}