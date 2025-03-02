package com.comunidadedevspace.imc

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

        val classificacao: String = if (result <= 18.5f){
          "MAGREZA"
        } else if (result > 19f && result <= 24.5f){
          "NORMAL"
        } else if (result > 25f && result<= 29.9f){
           "SOBREPESO"
        } else {
              "OBESIDADE"
            }

        tvClassificacao.text = classificacao


        when(classificacao){

            "MAGREZA" -> tvClassificacao.setTextColor(resources.getColor(R.color.MAGREZA))
            "NORMAL" -> tvClassificacao.setTextColor(resources.getColor(R.color.NORMAL))
            "SOBREPESO" -> tvClassificacao.setTextColor(resources.getColor(R.color.SOBREPESO))
            "OBESIDADE" -> tvClassificacao.setTextColor(resources.getColor(R.color.OBESIDADE))
        }

        }
    }