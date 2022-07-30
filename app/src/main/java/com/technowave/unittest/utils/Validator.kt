package com.technowave.unittest.utils

class Validator {
    fun validateUsername(username:String):Boolean{
        return username.isNotEmpty()
    }

    fun validatePassword(password:String):Boolean{
        return password.isNotEmpty()
    }

    fun calculateSum(a:Int, b:Int):Int {
        return  a+ b
    }
}