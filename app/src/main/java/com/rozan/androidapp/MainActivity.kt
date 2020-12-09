package com.rozan.androidapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() { //activity is what we see in screen
    private lateinit var et1:EditText
    private lateinit var et2:EditText
    private lateinit var btnCalculate:Button
    private lateinit var btnSubtract:Button
    private lateinit var btnMultiply:Button
    private lateinit var tvRes:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Reference/Binding
        et1=findViewById(R.id.et1)
        et2=findViewById(R.id.et2)
        tvRes=findViewById(R.id.tvres)

        btnCalculate=findViewById(R.id.btnCalculate)
        btnSubtract=findViewById(R.id.btnSubtract)
        btnMultiply=findViewById(R.id.btnMultiply)


        btnCalculate.setOnClickListener {
            addNumber()
        }
        btnSubtract.setOnClickListener {
            subtractNumber()
        }
        btnMultiply.setOnClickListener {
            multiplyNumber()
        }

        //extract values

    }
    private fun addNumber(){
        val fnum: Int = et1.text.toString().toInt()
        val snum: Int = et2.text.toString().toInt()
       sum(fnum,snum)
    }
    private fun sum(fnum:Int,snum:Int){
        val sum=fnum+snum


        Toast.makeText(this,"Sum is $sum",Toast.LENGTH_SHORT).show()
    }
    private fun subtractNumber(){
        val fnum: Int = et1.text.toString().toInt()
        val snum: Int = et2.text.toString().toInt()
        subtract(fnum,snum)
    }
    private fun subtract(fnum: Int,snum: Int){
        val sub=fnum-snum
        tvRes.text=sub.toString()
    }
    private fun multiplyNumber(){
        val fnum: Int = et1.text.toString().toInt()
        val snum: Int = et2.text.toString().toInt()
        multiply(fnum,snum)
    }
    private fun multiply(fnum: Int,snum: Int){
        val sub=fnum*snum
        tvRes.text=sub.toString()
    }

}