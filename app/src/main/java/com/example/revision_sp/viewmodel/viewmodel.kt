package com.example.revision_sp.viewmodel

import androidx.lifecycle.ViewModel

class viewmodel :ViewModel(){
    private var numOne = 0
    private var numTwo = 0
    private var result = 0
    fun getNumOne() : Int{
        return numOne
    }
    fun getNumTwo() : Int{
        return numTwo
    }
    fun getResult() : Int{
        return result
    }
    fun plus_op(num1:Int,num2:Int):Int{
        numOne = num1
        numTwo = num2
        result = numOne+numTwo
        return result
    }
    fun minus_op(num1:Int,num2:Int):Int{
        numOne = num1
        numTwo = num2
        result = numOne-numTwo
        return result
    }
    fun multi_op(num1:Int,num2:Int):Int{
        numOne = num1
        numTwo = num2
        result = numOne*numTwo
        return result
    }
    fun div_op(num1:Int,num2:Int):Int{
        numOne = num1
        numTwo = num2
        result = numOne/numTwo
        return result
    }

}