package com.example.AndroidCalculator
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.AndroidCalculator.R
import android.widget.Toast
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import kotlin.math.sin
import kotlin.math.cos

class AndroidCalculator : AppCompatActivity(), View.OnClickListener {

    lateinit var editText: EditText
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                val intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse("https://github.com/Juicement/GitDemo"))//创建一个Intent对象，使用https://github.com/Juicement/GitDemo的 Uri。
                startActivity(intent)// 这里启动了一个能够处理给定 Intent 的活动。
                true
            }
            R.id.action_exit -> {
                // do something for exit menu item
                finishAffinity()// 调用finishAffinity()关闭所有Activity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {//创建活动调用方法
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)   //设置布局
        editText = findViewById(R.id.edit_text) as EditText
        val button1 = findViewById(R.id.button_1) as Button
        val button2 = findViewById(R.id.button_2) as Button
        val button3 = findViewById(R.id.button_3) as Button
        val button4 = findViewById(R.id.button_4) as Button
        val button5 = findViewById(R.id.button_5) as Button
        val button6 = findViewById(R.id.button_6) as Button
        val button7 = findViewById(R.id.button_7) as Button
        val button8 = findViewById(R.id.button_8) as Button
        val button9 = findViewById(R.id.button_9) as Button
        val button0 = findViewById(R.id.button_0) as Button
        val button_add = findViewById(R.id.button_add) as Button
        val button_sub = findViewById(R.id.button_sub) as Button
        val button_mul = findViewById(R.id.button_mul) as Button
        val button_div = findViewById(R.id.button_div) as Button
        val button_del = findViewById(R.id.button_del) as Button
        val button_neg = findViewById(R.id.button_neg) as Button
        val button_equ = findViewById(R.id.button_equ) as Button
        val button_pt = findViewById(R.id.button_pt) as Button
        val button_pc = findViewById(R.id.button_pc) as Button
        val button_fac = findViewById(R.id.button_fac) as Button
        val button_c = findViewById(R.id.button_c) as Button
        val button_root = findViewById(R.id.button_root) as Button
        val button_sin = findViewById(R.id.button_sin) as Button
        val button_cos = findViewById(R.id.button_cos) as Button
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button_add.setOnClickListener(this)
        button_sub.setOnClickListener(this)
        button_mul.setOnClickListener(this)
        button_div.setOnClickListener(this)
        button_del.setOnClickListener(this)
        button_neg.setOnClickListener(this)
        button_equ.setOnClickListener(this)
        button_pt.setOnClickListener(this)
        button_pc.setOnClickListener(this)
        button_fac.setOnClickListener(this)
        button_c.setOnClickListener(this)
        button_sin.setOnClickListener(this)
        button_cos.setOnClickListener(this)
        button_root.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var et = editText.getText().toString()
        when (v?.getId()) {
            R.id.button_0 -> {
                if (et == "0") et = "0" else et += "0"
                editText.setText(et)
            }
            R.id.button_1 -> {
                if (et == "0") et = "1" else et += "1"
                editText.setText(et)
            }
            R.id.button_2 -> {
                if (et == "0") et = "2" else et += "2"
                editText.setText(et)
            }
            R.id.button_3 -> {
                if (et == "0") et = "3" else et += "3"
                editText.setText(et)
            }
            R.id.button_4 -> {
                if (et == "0") et = "4" else et += "4"
                editText.setText(et)
            }
            R.id.button_5 -> {
                if (et == "0") et = "5" else et += "5"
                editText.setText(et)
            }
            R.id.button_6 -> {
                if (et == "0") et = "6" else et += "6"
                editText.setText(et)
            }
            R.id.button_7 -> {
                if (et == "0") et = "7" else et += "7"
                editText.setText(et)
            }
            R.id.button_8 -> {
                if (et == "0") et = "8" else et += "8"
                editText.setText(et)
            }
            R.id.button_9 -> {
                if (et == "0") et = "9" else et += "9"
                editText.setText(et)
            }
            R.id.button_pt -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.' ||
                (!et.contains("+") &&
                !et.contains("-") &&
                !et.contains("×") &&
                !et.contains("÷") &&
                et.contains("."))
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "."
                editText.setText(et)
            }
            R.id.button_add -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "+"
                editText.setText(et)
            }
            R.id.button_sub -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "-"
                editText.setText(et)
            }
            R.id.button_mul -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "×"
                editText.setText(et)
            }
            R.id.button_div -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "÷"
                editText.setText(et)
            }
            R.id.button_del -> {
                et = if (et.length > 1) {
                    if (et.length == 2 && et[0] == '-') {
                        "0"
                    } else et.substring(0, et.length - 1)
                } else {
                    "0"
                }
                editText.setText(et)
            }
            R.id.button_c -> {
                et = "0"
                editText.setText(et)
            }
            R.id.button_equ -> if (et[et.length - 1] == '+' ||
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷') {
                Toast.makeText(
                    this@AndroidCalculator,
                    "Please complete the formula!",
                    Toast.LENGTH_SHORT
                ).show()
                editText.setText(et)
            } else {
                val res = getResult()
                if (res.contains("Infinity")) {
                    Toast.makeText(
                        this@AndroidCalculator,
                        "0 cannot be used as a divior!",
                        Toast.LENGTH_SHORT
                    ).show()
                    editText.setText("0")
                } else {
                    editText.setText(res)
                }
            }
            R.id.button_pc -> {
                var per = et.toDouble()
                per = per / 100
                var per1 = "" + per
                per1 = per1.replace("0+?$".toRegex(), "")
                per1 = per1.replace("[.]$".toRegex(), "")
                editText.setText(per1)
            }
            R.id.button_neg -> if (et[0] >= '0' && et[0] <= '9') {
                if (et == "0") {
                    editText.setText("0")
                } else {
                    editText.setText("-$et")
                }
            } else if (et[0] == '-') editText.setText(
                et.substring(1, et.length)
            ) else editText.setText(et)
            R.id.button_fac -> if (et.contains(".")) {
                Toast.makeText(this@AndroidCalculator,
                    "Not integer!",
                    Toast.LENGTH_SHORT).show()
            } else if (et[0] == '-') {
                Toast.makeText(this@AndroidCalculator,
                    "Not positive!",
                    Toast.LENGTH_SHORT).show()
            } else {
                if (et == "0") {
                    et = "1"
                    editText.setText(et)
                } else {
                    val num = et.toInt().toDouble()
                    var result = 1.0
                    var i = 1
                    while (i <= num) {
                        result = result * i
                        i++
                    }
                    et = result.toString()
                    editText.setText(et)
                }
            }

            R.id.button_root -> if (et[0] == '-') {
                Toast.makeText(
                    this@AndroidCalculator,
                    "Negative numbers cannot be squared!",
                    Toast.LENGTH_SHORT
                ).show()
                editText.setText("0")
            } else if (et.contains("+") ||
                et.contains("-") ||
                et.contains("×") ||
                et.contains("÷")
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Symbols cannot be squared!",
                    Toast.LENGTH_SHORT)
                    .show()
                editText.setText("0")
            } else {
                var x = et.toDouble()
                x = Math.sqrt(x)
                var x2 = formatResult(x)
                editText.setText(x2)
            }
            R.id.button_sin -> {
                val num = BigDecimal(et) // EditText中获取输入的数值，并将其转换为BigDecimal
                val result = BigDecimal(Math.sin(Math.toRadians(num.toDouble())))
                et = result.setScale(15, RoundingMode.HALF_UP).toPlainString() //使用 setScale方法设置结果的小数位数，并使用HALF_UP舍入模式进行舍入。
                editText.setText(et)
            }
            R.id.button_cos -> {
                val num = BigDecimal(et)
                val result = BigDecimal(Math.cos(Math.toRadians(num.toDouble())))
                et = result.setScale(15, RoundingMode.HALF_UP).toPlainString()
                editText.setText(et)
            }
            else -> {
                Toast.makeText(this@AndroidCalculator,
                    "Unexpected error!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun formatResult(result: Double): String {
        var re = String.format("%.9f", result)//转换为9位小数字符串
        re = re.replace("0+?$".toRegex(), "")//去0
        re = re.replace("[.]$".toRegex(), "")//去多余的小数点
        return re
    }

    fun getResult(): String {
        val infix = editText.getText().toString()
        val postfix = toPostfix(infix)
        val result = toValue(postfix)
        var re = formatResult(result)
        return re
    }


    fun toPostfix(infix: String): StringBuffer {
//将中缀表达式转换为后缀表达式的算法实现
        val stack = Stack<String>()
//创建一个空的操作符栈
        val postfix = StringBuffer(infix.length * 2)
//创建一个空的字符串缓冲器
        var i = 0
//初始化一个循环计数器变量i为0
        while (i < infix.length) {
//开始遍历中缀表达式
            var ch = infix.get(i)
//从中缀表达式中获取第i个字符
            when (ch) {
//判断当前字符是什么
                '+' -> {
//是加法的情况
                    while (!stack.isEmpty() && stack.peek() != "(")
//从操作符栈中弹出优先级大于等于加法的所有操作符
                        postfix.append(stack.pop())
//将优先级大于等于加法的所有操作符加入到后缀表达式中
                    stack.push(ch.toString() + "")
//将加法操作符加入到操作符栈中
                    i++
                }
                '-' -> if (i == 0) {
//是减法的情况
                    postfix.append(0)
//当前字符是中缀表达式的第一个字符的前提情况
                    postfix.append(" ")
//将0和减法操作符加入到后缀表达式中
                    stack.push("(")
                    stack.push(ch.toString() + "")
//将减法操作符入栈
                    i++
                } else {
//另一种情况
                    while (!stack.isEmpty() && stack.peek() != "(")
//是减法，但不是中缀表达式的第一个字符的情况
                        postfix.append(stack.pop())
//从操作符栈中弹出优先级大于等于减法的所有操作符，并将它们加入到后缀表达式中
                    stack.push(ch.toString() + "")
//将减法操作符加入到栈中
                    i++
                }
                '×', '÷' -> {
//判断当前字符是否是乘法或除法
                    while (!stack.isEmpty() &&
                        (stack.peek() == "×" || stack.peek() == "÷"))
//如果是乘法或除法，从操作符栈中弹出优先级大于乘法或除法的所有操作符
                        postfix.append(stack.pop())
//将优先级大于乘法或除法的所有操作符加入到后缀表达式中
                    stack.push(ch.toString() + "")
//将当前操作符加入到操作符栈中
                    i++
                }
                else -> if (i == 1 && infix.get(0) == '-') {
//当前字符不是操作符的情况，将其视为操作数
                    while (i < infix.length && ch >= '0' && ch <= '9' ||
                        i < infix.length && ch == '.')
//处理特殊情况，while循环的条件是i小于中缀表达式的长度，并且当前字符是一个数字或小数点
                    {
                        postfix.append(ch)
//将负号追加到后缀表达式中
                        i++
                        if (i < infix.length) ch = infix.get(i)
//如果当前字符后面还有字符，则获取下一个字符
                    }
                    postfix.append(" ")
//在追加完中缀表达式中的负数后，需要在后缀表达式中添加一个空格
                    postfix.append('-')
                    stack.pop()
                    stack.pop()
//将前面弹出的负号加入到后缀表达式中
                } else
//如果当前字符不是负数，则直接跳过
                {
                    while (i < infix.length && ch >= '0' && ch <= '9' ||
                        i < infix.length && ch == '.')
//处理特殊情况，如果下一个字符是数字或小数点，则将其追加到后缀表达式中
                    {
                        postfix.append(ch)
                        i++
                        if (i < infix.length) ch = infix.get(i)
                    }
                    postfix.append(" ")
//在追加完中缀表达式中的负数后，需要在后缀表达式中添加一个空格
                }
            }
        }

        while (!stack.isEmpty())
//处理完中缀表达式后的情况
            postfix.append(stack.pop())
//将栈中所有剩余的操作符弹出，并加入到后缀表达式中
        return postfix
//返回转换后的后缀表达式
    }


    fun toValue(postfix: StringBuffer): Double {
//计算后缀表达式的值，并将结果返回
        val stack = Stack<Double>()
//创建一个双精度浮点数类型的栈，用于存放操作数
        var value = 0.0
//定义变量value并初始化为0，用于保存操作数
        var j = 0
        var i = 0
//定义两个变量i和j，用于遍历后缀表达式中的字符
        while (i < postfix.length) {
//当i小于后缀表达式的长度的情况
            j = i
//将j初始化为i，用于记录操作数的起始位置
            var ch = postfix.get(i)
//获取当前字符并进行判断
            if (ch >= '0' && ch <= '9' || ch == '.') {
//如果是数字或小数点，则说明是操作数
                value = 0.0
//将value重新赋值为0，用于保存当前操作数的值
                while (ch != ' ') {
//当前字符不为空格时的情况
                    while (ch != ' ' && ch != '.') {
//当前字符为数字时且非小数点的情况
                        value = value * 10.0 + (ch - '0').toDouble()
//转换为Double 类型的数字并加入到 value 的小数位
                        j++
                        ch = postfix.get(++i)
//更新计数器 j 和指针 i。
                    }
                    if (ch != ' ' && ch == '.') ch = postfix.get(++i)
//当前字符 ch 是小数点，直接跳过并读取下一个字符
                    while (ch != ' ' && i >= j + 1) {
//当前字符 ch 是小数点，或者是整数后的小数部分的情况
                        val valueBD = BigDecimal(value.toString())
//将其转换为 BigDecimal 类型
                        val chBD = BigDecimal(ch - '0')
                        val nBD = BigDecimal(Math.pow(10.0, (i - j).toDouble()))
//使用 10 ^ (i-j) 计算出小数位的位数
                        val temp = chBD.divide(nBD)
                        value = valueBD.add(temp).toDouble()
                        ch = postfix.get(++i)
//将其按小数位划分，并进行计算
                    }
                    stack.push(value)
//将计算出的 value 推入栈中
                }
            } else {
                if (ch != ' ') {
//当前字符是操作符时
                    var y: Double = stack.pop()
                    var x: Double = stack.pop()
//从栈中弹出两个数
                    value = when (ch) {
//根据操作符进行计算
                        '+' -> x + y
                        '-' -> x - y
                        '×' -> x * y
                        '÷' -> x / y
//加减乘除的计算
                        else -> 0.0
//加减乘除以外的情况，程序将其视为无效操作，返回 0.0 作为默认的计算结果
                    }
                    stack.push(value)
//将计算结果推入栈中
                }
            }
            i++
//指针 i 前移一位
        }
        return stack.pop()
//返回栈中最终的计算结果
    }

}