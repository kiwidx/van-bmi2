package com.kiwi.bmi2
fun main(){
    println("九九乘法表第一版")
    for(i in 1..9){
        for(j in 1..9){
            print("${if(i*j < 10) " " else ""}${i*j}\t")    //if..else也能當表達式
        }
        println()
    }
    println("九九乘法表第二版")
    var q: Int
    var w: Int
    //var num = readLine()!!.toInt()
    for (q in 1..20){
        if(q.rem(3) == 0){
            for(w in 1..20){
                print("${if(q*w < 10) " " else ""}$q*$w = ${q*w}\t")
            }
            println("")
        }
    }
}
class MultiTable {
}