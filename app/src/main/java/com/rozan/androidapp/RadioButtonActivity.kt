package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_radio_button.*

class RadioButtonActivity : AppCompatActivity() {

    private lateinit var etfirst:EditText
    private lateinit var etsecond:EditText
    private lateinit var rdoAdd:RadioButton
    private lateinit var rdoSubtract:RadioButton
    private lateinit var rdoMultiply:RadioButton
    private lateinit var btnCalculate: Button
    private lateinit var tvRes:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        etfirst=findViewById(R.id.et1)
        etsecond=findViewById(R.id.et2)
        tvRes=findViewById(R.id.tvres)
        rdoAdd=findViewById(R.id.rdoAdd)
        rdoSubtract=findViewById(R.id.rdoSubtract)
        rdoMultiply=findViewById(R.id.rdoMultiply)
        btnCalculate=findViewById(R.id.btnCalculate)
        btnCalculate.setOnClickListener {
            //Validation
            if(TextUtils.isEmpty(etfirst.text)){
                etfirst.error="Enter first number"
                etfirst.requestFocus()
                return@setOnClickListener

            }
            else if(TextUtils.isEmpty(etsecond.text)){
                etsecond.error="Enter second number"
                etsecond.requestFocus()
                return@setOnClickListener
            }
            operation()
        }

    }
    private fun operation(){

        val first: Int = etfirst.text.toString().toInt()
        val second: Int = etsecond.text.toString().toInt()
        var result:Int=0

        if(rdoAdd.isChecked){
            result=first+second
        }
        else if(rdoSubtract.isChecked){
            result=first-second
        }
        if(rdoMultiply.isChecked){
            result=first*second
        }
        tvres.text=result.toString()
    }

}