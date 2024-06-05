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

        var percentege: Int = 0

        binding.rbOne.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                percentege = 10
            }
        }
        binding.rbTwo.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                percentege = 15
            }
        }
        binding.rbThree.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                percentege = 20
            }
        }

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
                val tips = totalCostAccount * percentege / 100
                val totalAccountWhitTip = totalCostAccount + tips
                binding.tvTotalValor.text = "R$  $totalAccountWhitTip"

                binding.buttonReset.setOnClickListener {
                    binding.tvTotalValor.text = ""
                    binding.edtPessoas.setText("")
                    binding.edtValor.setText("")
                    binding.rbOne.isChecked = false
                    binding.rbTwo.isChecked = false
                    binding.rbThree.isChecked = false

                }

            }
        }
    }
}