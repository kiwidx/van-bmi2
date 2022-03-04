package com.kiwi.bmi2

class MailBox constructor(
    var length: Int,
    var width: Int,
    var height: Int,
    var price: Int){
    fun volume(): Int{  //calculate mailbox volume for choosing mailbox
        return (length * width * height)
    }
}
fun main(){
    val small = MailBox(10,10,10,50)
    val medium = MailBox(10,10,15,60)
    val large = MailBox(10,15,15,70)
    print("length: ")
    var len: Int = readLine()!!.toInt()
    print("width: ")
    var wide: Int = readLine()!!.toInt()
    print("height: ")
    var hei: Int = readLine()!!.toInt()
    var Box: Int= len * wide * hei
    println("需求體積： " + Box)
    if(len > small.length || wide > small.width || hei > small.height){
        if(len > medium.length || wide > medium.width || hei > medium.height){
            if(len > large.length || wide > large.width || hei > large.height){
                println("長度超過現有箱子大小！")
                println("無法提供您適合的箱子")
            }else if(Box < large.volume()){
                println("適合大箱子,價錢： " + large.price)
            }
        }else if(Box < medium.volume()){
            println("適合中等箱子,價錢： " + medium.price)
        }
    }else if(Box < small.volume()){
        println("適合小箱子,價錢： " + small.price)
    }
}
