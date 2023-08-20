package com.example.atividade01

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class Atividade004 : MainActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.dark_mode -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            true
        }
        R.id.light_Mode->{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            true
        }
        R.id.func1 -> {
            startActivity(Intent(this,Atividade001::class.java))
            true
        }
        R.id.func2->{
            startActivity(Intent(this,Atividade002::class.java))
            true
        }
        R.id.func3 ->{
            startActivity(Intent(this,Atividade003::class.java))
            true
        }
        R.id.func5 ->{
            startActivity(Intent(this,Atividade005::class.java))
            true
        }
        R.id.func6 ->{
            startActivity(Intent(this,Atividade006::class.java))
            true
        }
        R.id.func7 ->{
            startActivity(Intent(this,Atividade007::class.java))
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val menuItemToHide = menu.findItem(R.id.func4)
        menuItemToHide?.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
    private lateinit var edtKilometragem:TextView
    private lateinit var edtLitro:TextView
    private lateinit var btn:Button
    private lateinit var message:TextView
    private fun validar():Boolean{
        if(edtKilometragem.text.isEmpty() || edtLitro.text.isEmpty()){
            Toast.makeText(this, "Não é possivel fazer o calculo com campos em branco", Toast.LENGTH_SHORT).show()
            edtKilometragem.text = ""
            edtLitro.text = ""
            return true
        }else if(edtKilometragem.text.toString().toDouble() <= 0.0 ||edtLitro.text.toString().toDouble() <= 0.0){
            Toast.makeText(this, "Não é possivel fazer o calculo com um dos campos com numero negativo ou zero", Toast.LENGTH_SHORT).show()
            edtKilometragem.text = ""
            edtLitro.text = ""
        }
        return false
    }
    private fun calcular(){
        val consumo = edtKilometragem.text.toString().toDouble() / edtLitro.text.toString().toDouble()
        message.text = "Consumo: $consumo"
        edtLitro.text = ""
        edtKilometragem.text = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade004)
        setSupportActionBar(findViewById(R.id.toolbar))
        edtKilometragem = findViewById(R.id.Atv04Kilometro)
        edtLitro = findViewById(R.id.Atv04Litro)
        btn = findViewById(R.id.Atv04Btn)
        message = findViewById(R.id.Atv04Message)
        btn.setOnClickListener {
            if (validar()){

            }else{
                calcular()
            }
        }
    }
}