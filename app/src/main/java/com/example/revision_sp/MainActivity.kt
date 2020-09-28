package com.example.revision_sp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.revision_sp.viewmodel.viewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val shardFile = "SHAREPREFERENCE"
    var sharedpreferences:SharedPreferences? = null
//    var num1:SharedPreferences? = null
//    var num2:SharedPreferences? = null
//    var tv_result:SharedPreferences? = null
    var editor :SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var vm = ViewModelProvider(this).get(viewmodel::class.java)
//        num1 = this.getSharedPreferences(shardFile,Context.MODE_PRIVATE)
//        num2 = this.getSharedPreferences(shardFile,Context.MODE_PRIVATE)
//        tv_result = this.getSharedPreferences(shardFile,Context.MODE_PRIVATE)
        sharedpreferences = this.getSharedPreferences(shardFile,Context.MODE_PRIVATE)
        editor = sharedpreferences?.edit()
        var num1 = sharedpreferences?.getInt("NUMBERONE",0)
        var num2 = sharedpreferences?.getInt("NUMBERTWO",0)
        var re = sharedpreferences?.getInt("RESULT",0)
        etnum1.setText(num1.toString())
        etnum2.setText(num2.toString())
        tvResult.text = re.toString()
//        editor = num1?.edit()
//        editor = num2?.edit()
//        editor = tv_result?.edit()
//        var n1 = num1?.getInt("NUMBERONE",0)
//        var n2 = num2?.getInt("NUMBERTWO",0)
//        var re = tv_result?.getInt("RESULT",0)
//        etnum1.setText(num1.toString())
//        etnum2.setText(num2.toString())
//        tvResult.text = tv_result.toString()
        btnPlus.setOnClickListener {
            var num1 = etnum1.text.toString().toInt()
            var num2 = etnum2.text.toString().toInt()
            var result = vm.plus_op(num1,num2)
            tvResult.text = result.toString()
        }
        btnMinus.setOnClickListener {
            var num1 = etnum1.text.toString().toInt()
            var num2 = etnum2.text.toString().toInt()
            var result = vm.minus_op(num1,num2)
            tvResult.text = result.toString()
        }
        btnMulti.setOnClickListener {
            var num1 = etnum1.text.toString().toInt()
            var num2 = etnum2.text.toString().toInt()
            var result = vm.multi_op(num1,num2)
            tvResult.text = result.toString()
        }
        btnDiv.setOnClickListener {
            var num1 = etnum1.text.toString().toInt()
            var num2 = etnum2.text.toString().toInt()
            var result = vm.div_op(num1,num2)
            tvResult.text = result.toString()
        }

    }

    override fun onPause() {
        super.onPause()
        editor?.putInt("NUMBERONE",etnum1.text.toString().toInt())
        editor?.putInt("NUMBERTWO",etnum2.text.toString().toInt())
        editor?.putInt("RESULT",tvResult.text.toString().toInt())
        editor?.apply()
    }
}