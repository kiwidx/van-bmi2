package com.kiwi.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.kiwi.bmi2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding  //lateinit告訴機器這個變數的值晚一點給，不會是null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)  //inflate類似給binding設定初值
        setContentView(binding.root)    //get view
    }

    fun bmi(view: View){
        var weight = binding.edWeight.text.toString().toFloat()
        var height = binding.edHeight.text.toString().toFloat()
        var bmi = weight / (height * height)
        Log.d("BMI", bmi.toString())  //彈出對話視窗顯示結果
    }
}