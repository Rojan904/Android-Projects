package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SpinnerActivity : AppCompatActivity() {

    private val languages=arrayOf("Nepali","Hindi","English")
    private lateinit var spinner: Spinner
    private lateinit var autoComplete:AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        spinner=findViewById(R.id.spinner)
        autoComplete=findViewById(R.id.autoComplete)

        //For autocomplete textview
        val autoCompleteAdapter=ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,languages)
        autoComplete.setAdapter(autoCompleteAdapter)
        autoComplete.threshold=1


        //For Spinner Adapter
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,languages)
        spinner.adapter=adapter
        spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem=parent?.getItemAtPosition(position).toString()

                Toast.makeText(this@SpinnerActivity,"selected Item: $selectedItem",Toast.LENGTH_SHORT).show()

            }

        }
    }
}