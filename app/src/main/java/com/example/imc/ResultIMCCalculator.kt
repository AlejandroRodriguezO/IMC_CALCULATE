package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.imc.MainActivity.Companion.IMC_KEY

class ResultIMCCalculator : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDesc: TextView
    private lateinit var btnReCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imccalculator)

        val result:Double = intent.extras?.getDouble(IMC_KEY) ?:-1.0

        initComponents()

        initUI(result)

        initListeners()

    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 -> {//bajo peso
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDesc.text = getString(R.string.desc_bajo_peso)
            }
            in 18.51..24.99 -> {//peso normal
                tvResult.text = getString(R.string.title_normal_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDesc.text = getString(R.string.desc_normal_peso)
            }
            in 25.00..29.99 -> {//sobre peso
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDesc.text = getString(R.string.desc_sobrepeso)
            }
            in 30.00..99.99 -> {//Obesidad
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDesc.text = getString(R.string.desc_obesidad)
            }
            else -> {//error
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDesc.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDesc = findViewById(R.id.tvDesc)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}