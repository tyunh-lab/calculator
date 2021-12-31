package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var value : Int = 0
        var clear : Boolean = false
        var calc = false
        var operator : String? = null
        val buttonZero : Button = findViewById(R.id.zero)
        val buttonOne : Button = findViewById(R.id.one)
        val buttonTwo : Button = findViewById(R.id.two)
        val buttonThree : Button = findViewById(R.id.three)
        val buttonFour : Button = findViewById(R.id.four)
        val buttonFive : Button = findViewById(R.id.five)
        val buttonSix : Button = findViewById(R.id.six)
        val buttonSeven : Button = findViewById(R.id.seven)
        val buttonEight : Button = findViewById(R.id.eight)
        val buttonNine : Button = findViewById(R.id.nine)
        val buttonAdd : Button = findViewById(R.id.add)
        val buttonMul : Button = findViewById(R.id.mul)
        val buttonSub : Button = findViewById(R.id.sub)
        val buttonDiv :Button = findViewById(R.id.div)
        val buttonEqual:Button = findViewById(R.id.equal)
        val buttonClear : Button = findViewById(R.id.clear)
        val textArea : TextView = findViewById(R.id.display)
        fun numButtonAction(num : String) {
            textArea.text = if(textArea.text.toString() != "0" && clear == false){
                textArea.text.toString() + num
            } else {
                clear = false
                num
            }
            calc = true
        }
        /* 計算の実処理を行う関数 */
        fun calculation(op : String?) :Int {
            if (op == "+") {
                return value + textArea.text.toString().toInt()
            } else if (op == "-") {
                return value - textArea.text.toString().toInt()
            } else if (op == "*") {
                return value * textArea.text.toString().toInt()
            } else if (op == "/") {
                return value / textArea.text.toString().toInt()
            } else {
                return textArea.text.toString().toInt()
            }
        }

        /* 計算ボタンを押された時の処理をまとめた関数 */
        fun calcButtonAction(op : String?) {
            /* 計算処理有効の場合のみ計算と表示の更新を行う */
            if (calc) {
                value = calculation(operator)
                clear = true
                calc = false
                textArea.text = value.toString()
            }
            /* 演算子は計算処理無効でも更新 */
            operator = op
        }

        buttonClear.setOnClickListener {
            textArea.text ="0"
            value = 0
            operator = null
            clear = false
            calc = false
        }

        /* 数字ボタンを押された時の処理 */
        /* 表示領域を更新 */
        buttonZero.setOnClickListener   { numButtonAction("0") }
        buttonOne.setOnClickListener    { numButtonAction("1") }
        buttonTwo.setOnClickListener    { numButtonAction("2") }
        buttonThree.setOnClickListener  { numButtonAction("3") }
        buttonFour.setOnClickListener   { numButtonAction("4") }
        buttonFive.setOnClickListener   { numButtonAction("5") }
        buttonSix.setOnClickListener    { numButtonAction("6") }
        buttonSeven.setOnClickListener  { numButtonAction("7") }
        buttonEight.setOnClickListener  { numButtonAction("8") }
        buttonNine.setOnClickListener   { numButtonAction("9") }


        /* 計算ボタンが押された時の処理 */
        buttonAdd.setOnClickListener { calcButtonAction("+") }
        buttonMul.setOnClickListener { calcButtonAction("*") }
        buttonSub.setOnClickListener { calcButtonAction("-") }
        buttonDiv.setOnClickListener { calcButtonAction("/") }

        /* "="ボタンが押された時の処理 */
        buttonEqual.setOnClickListener {
            /* 計算処理有効の場合のみ計算と表示の更新を行う */
            if (calc) {
                value = calculation(operator)
                calc = false
                clear = true
                textArea.text = value.toString()
                operator = null
            }
        }
    }
}