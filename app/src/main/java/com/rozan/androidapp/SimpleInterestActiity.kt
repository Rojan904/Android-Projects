package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class SimpleInterestActiity : AppCompatActivity()
{
    //Global variable
    //Latiniet can be used only in complex data type
    private lateinit var etPrinciple:EditText
    private lateinit var etRate:EditText
    private lateinit var etTime:EditText
    private lateinit var btnCalculate:Button
    private lateinit var tvResult:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_interest_actiity)

        //Reference
         etPrinciple=findViewById(R.id.etPrinciple)
        etRate=findViewById(R.id.etRate)
         etTime=findViewById(R.id.etTime)
         tvResult=findViewById(R.id.tvresult)
         btnCalculate=findViewById(R.id.btnSI)

        btnCalculate.setOnClickListener {
           calculate()
        }

    }
    private fun calculate(){
        val principle:Float=etPrinciple.text.toString().toFloat()
        val rate:Float=etRate.text.toString().toFloat()
        val time:Float=etTime.text.toString().toFloat()

      calculateSI(principle,rate, time)


    }
    private fun calculateSI(principle:Float,rate:Float,time:Float){

        val SI= (principle*rate*time)/100
        Toast.makeText(this, "Simple Interest is $SI", Toast.LENGTH_SHORT).show()
        tvResult.text=SI.toString()

    }
}