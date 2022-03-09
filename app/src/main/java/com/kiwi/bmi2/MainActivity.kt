package com.kiwi.bmi2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AlertDialog
import com.kiwi.bmi2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    val REQUEST_DISPLAY_BMI = 16
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
//        Log.d("MainActivity", "clicked")//.d:debug message   app上線take out
        Toast.makeText(this, "Your BMI $bmi", Toast.LENGTH_LONG).show()  //將bmi結果以浮動Toast方式短暫顯示在app頁面下方
        AlertDialog.Builder(this)   //anonymous方式建立Builder
            .setMessage(bmi.toString())    //show dialog message
            .setTitle("Your BMI")          //dialog title
            .setPositiveButton("OK",) { dialog, which ->
                binding.edWeight.setText("")
                binding.edHeight.setText("")
            }  //check ok and then close the dialog
            //.setNeutralButton("Cancel",null)//check cancel and then close the dialog
            //.show()
        binding.tvBmi.text = "Your BMI is $bmi"
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("BMI",bmi)
        startActivityForResult(intent, REQUEST_DISPLAY_BMI)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult: ")
        if(requestCode == REQUEST_DISPLAY_BMI && resultCode == RESULT_OK){
            Log.d(TAG, "back from ResultActivity")
        }
    }
    //contract合約方法取得ResultActivity的回傳值
    class NameContract : ActivityResultContract<Unit, String>(){
        override fun createIntent(context: Context, input: Unit?): Intent {
            return Intent(context, ResultActivity::class.java)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String {
            if (resultCode == RESULT_OK) {
                val name = intent!!.getStringExtra("NAME")
                return name!!
            } else {
                return "No name"
            }
        }
    }

}