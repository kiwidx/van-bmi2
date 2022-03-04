package com.kiwi.bmi2

import kotlin.random.Random

class Guess1to100 {

}
fun main(){
    var min = 1     //設定範圍１到１００
    var max = 100
    var times = 0   //計算猜的次數
    var num = 0    //猜測數字
    var secret: Int = Random.nextInt(100)+1  //終極密碼
    println("終極密碼(最多猜6次):")
    while (num != secret){
        println("Please input a number between " + min + " and " + max)
        times++
        println("第 " + times + " 次輸入： ")
        num = readLine()!!.toInt()
        if(num > max || num < min){     //錯誤範圍
            println("input number isn't in correct range!!")
        }else{      //change input number to range boundary
            if(num > secret){
                max = num
            }else if(num < secret){
                min =num
            }else if(num == secret){
                println("You got it!")
            }
            if(num != secret && times >= 6){    //if you input six times but the number is still error
                println("You have failed!!")
                println("正解: " + secret)
                break
            }
        }
    }


}