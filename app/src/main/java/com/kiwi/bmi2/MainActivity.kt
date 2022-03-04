package com.kiwi.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG).show()  //將bmi結果以浮動Toast方式短暫顯示在app頁面下方
        AlertDialog.Builder(this)   //anonymous方式建立Builder
            .setMessage(bmi.toString())    //show dialog message
            .setTitle("Your BMI")          //dialog title
            .setPositiveButton("OK",null)   //check ok and then close the dialog
            .setNeutralButton("Cancel",null)//check cancel and then close the dialog
            .show()
    }
}