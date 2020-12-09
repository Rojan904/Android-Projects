package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_floating_action_button.*

class FloatingActionButtonActivity : AppCompatActivity() {
    private lateinit var floatingBtn:FloatingActionButton
    private lateinit var num1:EditText
    private lateinit var num2:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_action_button)
        floatingBtn=findViewById(R.id.floatingBtn)
        num1=findViewById(R.id.num1)
        num2=findViewById(R.id.num2)


        floatingBtn.setOnClickListener{
           add()
        }

    }
    private fun add(){
        val num1:Int=num1.text.toString().toInt()
        val num2:Int=num2.text.toString().toInt()
        result(num1,num2)
    }
    private fun result(num1:Int,num2:Int){
        val result=num1+num2
        Toast.makeText(this,"Sum is $result",Toast.LENGTH_SHORT).show()
    }
}