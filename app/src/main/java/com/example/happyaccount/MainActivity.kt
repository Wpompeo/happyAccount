package com.example.happyaccount

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.happyaccount.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculater.setOnClickListener{
            val numberOfPeopleStr : String = binding.edtPessoas.text.toString()
            val costAccountStr : String = binding.edtValor.text.toString()

            if( numberOfPeopleStr == "" || costAccountStr == ""){
                Snackbar.make(
                    binding.edtPessoas,
                    "Preencha todos os campos!",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {

                val numberOfPeople = numberOfPeopleStr.toFloat()
                val costAccount = costAccountStr.toFloat()
                val totalCostAccount = costAccount / numberOfPeople
                val costFinal = findViewById<TextView>(R.id.tv_total_valor)
                costFinal.text =  "R$ " + totalCostAccount.toString()
            }
        }
    }
}