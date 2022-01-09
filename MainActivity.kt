package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var inputBox: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputBox = findViewById(R.id.inputBox)

    }

    var dot: Boolean=false
    var newOp: Boolean=true
    var operator: String = ""
    lateinit var firstNum: String

    fun getNumber(view:View){

        if(newOp){
            inputBox.text=""
        }
        newOp=false

        var getText: String = inputBox.text.toString()
        val selectedBtn = view as Button

        when(selectedBtn.id){
            R.id.bt0->{
                getText+="0"
            }
            R.id.bt1->{
                getText+="1"
            }
            R.id.bt2->{
                getText+="2"
            }
            R.id.bt3->{
                getText+="3"
            }
            R.id.bt4->{
                getText+="4"
            }
            R.id.bt5->{
                getText+="5"
            }
            R.id.bt6->{
                getText+="6"
            }
            R.id.bt7->{
                getText+="7"
            }
            R.id.bt8->{
                getText+="8"
            }
            R.id.bt9->{
                getText+="9"
            }
            R.id.btDot->{
                if(!dot){
                    getText+="."
                }
                dot=true
            }

        }
        inputBox.text=getText
    }



    fun getOperator(view: View){
        val selectedOp = view as Button

        when(selectedOp.id){
            R.id.btpercent->{
                operator="%"
            }
            R.id.btDiv->{
                operator="/"
            }
            R.id.btMul->{
                operator="x"
            }
            R.id.btAdd->{
                operator="+"
            }
            R.id.btSub->{
                operator="-"
            }
        }
        firstNum=inputBox.text.toString()
        dot=false
        newOp=true
    }

    fun equalOp(view: View){
        val secondNum = inputBox.text.toString()
        var result: Double?=null

        when(operator){
            "/"->{
                result = firstNum.toDouble() / secondNum.toDouble()
            }
            "x"->{
                result = firstNum.toDouble() * secondNum.toDouble()
            }
            "+"->{
                result = firstNum.toDouble() + secondNum.toDouble()
            }
            "-"->{
            result = firstNum.toDouble() - secondNum.toDouble()
            }
            "%"->{
                result = firstNum.toDouble() / 100
            }
        }
        inputBox.text=result.toString()
    }

    fun cleanInput(view: View){
        inputBox.text=""
        newOp=true
        dot=false
    }
}