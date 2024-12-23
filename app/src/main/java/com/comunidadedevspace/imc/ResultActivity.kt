package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
            tvResult.text = result.toString()

        var classificacao: String? = null
        var corClassificacao = ""

        if(result <= 18.5f){
            classificacao = "MAGREZA"
            corClassificacao = "#00BFFF" // Cor Azul Claro
        } else if(result > 18.5f && result <= 24.9f){
            classificacao = "NORMAL"
            corClassificacao = "#32CD32" // Cor Verde
        } else if(result >25f && result <= 29.9f){
            classificacao = "SOBREPESO"
            corClassificacao = "#FFA500" // Cor Laranja
        } else if(result > 30f && result <= 39.9f){
            classificacao = "OBESIDADE"
            corClassificacao = "#FF4500" // Cor Vermelho laranja
        } else {

            classificacao = "OBESIDADE GRAVE"
            corClassificacao = "#FF0000" // Cor Vermelha

        }
        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(Color.parseColor(corClassificacao))
    }
    }