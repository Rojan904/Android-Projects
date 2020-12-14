package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AlertActivity : AppCompatActivity() {
    private lateinit var etNum1:EditText
    private lateinit var etNum2:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        val button: Button =findViewById(R.id.btnalert)
        etNum1=findViewById(R.id.etNum1)
        etNum2=findViewById(R.id.etNum2)
        button.setOnClickListener {
            val builder=AlertDialog.Builder(this)
            //title for alert dialog
            builder.setTitle("My Alert");
            //message for alert dialog
            builder.setMessage("Are you sure?")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            //performing positive action
            builder.setPositiveButton("Yes"){dialogInterface, which ->
                 add()
//                Toast.makeText(applicationContext, "Clicked yes", Toast.LENGTH_SHORT).show()
            }

            builder.setNeutralButton("Cancel"){dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked cancel", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked no", Toast.LENGTH_SHORT).show()
            }
            //Create alert dialog
            val alertDialog:AlertDialog=builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }


    }
    fun add(){
        val fnum: Int = etNum1.text.toString().toInt()
        val snum: Int = etNum2.text.toString().toInt()
        sum(fnum,snum)
    }
    private fun sum(fnum:Int,snum:Int){
        val sum=fnum+snum


        Toast.makeText(this,"Sum is $sum",Toast.LENGTH_SHORT).show()
    }
}