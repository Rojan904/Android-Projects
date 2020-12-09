package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {
    private lateinit var tvDisplay: TextView
    private lateinit var tvStore: TextView
    private lateinit var btn0:Button
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private lateinit var btn3:Button
    private lateinit var btn4:Button
    private lateinit var btn5:Button
    private lateinit var btn6:Button
    private lateinit var btn7:Button
    private lateinit var btn8:Button
    private lateinit var btn9:Button
    private lateinit var btnDot:Button
    private lateinit var btnDivide:Button
    private lateinit var btnMultiply:Button
    private lateinit var btnSubtract:Button
    private lateinit var btnAdd:Button
    private lateinit var btnOn:Button
    private lateinit var btnEqualsTo:Button

    var digitonscreen=StringBuilder()
    var digitonstore=StringBuilder()
    var firstNumber:Double=0.0
    var secondNumber:Double=0.0
    private var operation:Char='c'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        tvDisplay=findViewById(R.id.tvdisplay)
        btn0=findViewById(R.id.btn0)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn4=findViewById(R.id.btn4)
        btn5=findViewById(R.id.btn5)
        btn6=findViewById(R.id.btn6)
        btn7=findViewById(R.id.btn7)
        btn8=findViewById(R.id.btn8)
        btn9=findViewById(R.id.btn9)
        btnDot=findViewById(R.id.btndot)
        btnDivide=findViewById(R.id.btndivide)
        btnMultiply=findViewById(R.id.btnmultiply)
        btnSubtract=findViewById(R.id.btnsubtract)
        btnAdd=findViewById(R.id.btnadd)
        btnOn=findViewById(R.id.btnon)
        btnEqualsTo=findViewById(R.id.btnequalsto)
        tvStore=findViewById(R.id.tvstore)

        setButtons()
    }
    private fun setButtons(){
        btn0.setOnClickListener {
            appendDigit("0")
        }
        btn1.setOnClickListener {
            appendDigit("1")
        }
        btn2.setOnClickListener {
            appendDigit("2")
        }
        btn3.setOnClickListener {
            appendDigit("3")
        }
        btn4.setOnClickListener {
            appendDigit("4")
        }
        btn5.setOnClickListener {
            appendDigit("5")
        }
        btn6.setOnClickListener {
            appendDigit("6")
        }
        btn7.setOnClickListener {
            appendDigit("7")
        }
        btn8.setOnClickListener {
            appendDigit("8")
        }
        btn9.setOnClickListener {
            appendDigit("9")
        }
        btnDot.setOnClickListener {
            appendDigit(".")
        }


    }
    private fun appendDigit(digit:String){
        digitonscreen.append(digit)  //Adds digit to string builder
        tvDisplay.text=digitonscreen.toString()
        digitonstore.append(digit)
        tvStore.text=digitonstore.toString()

        operationButton()
    }

    private fun operationButton(){
        btnAdd.setOnClickListener{
            setOperation('+')

        }
        btnSubtract.setOnClickListener {
            setOperation('-')
        }
        btnMultiply.setOnClickListener {
            setOperation('*')
        }
        btnDivide.setOnClickListener {
            setOperation('/')

        }
        btnOn.setOnClickListener {
            digitonscreen.clear()
            digitonstore.clear()
            tvDisplay.text="0"
        }
    }
//    private fun appendToStore(operationDigit:String){
//        if (operationDigit=="+")
//        {
//            digitonstore.append(operationDigit)
//        }
//
//    }
    private fun setOperation(c:Char){
        operation=c
        firstNumber=digitonscreen.toString().toDouble()
//        tvStore.text=firstNumber.toString()
        digitonscreen.clear()
        tvStore.text=digitonstore.append(operation)
        tvDisplay.text="0"

        btnEqualsTo.setOnClickListener{
            MathOperation()
        }
    }
    private fun MathOperation(){
        secondNumber=digitonscreen.toString().toDouble()
//        tvStore.text=secondNumber.toString()
        digitonscreen.clear()


        when(operation){
            '+'->{
                val sum=firstNumber+secondNumber
                tvDisplay.text=sum.toString()
                digitonscreen.append(sum)
                digitonstore.append(sum)

            }
            '-'->{
                val sub=firstNumber-secondNumber
                tvDisplay.text=sub.toString()
                digitonscreen.append(sub)

            }
            '*'->{
                val mul=firstNumber*secondNumber
                tvDisplay.text=mul.toString()
                digitonscreen.append(mul)
            }
            '/'->{
                val div=firstNumber/secondNumber
                tvDisplay.text=div.toString()
                digitonscreen.append(div)
            }

        }
    }
}