package com.example.atividade01

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class Atividade002 : MainActivity() {
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
        R.id.func3->{
            startActivity(Intent(this,Atividade003::class.java))
            true
        }
        R.id.func4 ->{
            startActivity(Intent(this,Atividade004::class.java))
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
        val menuItemToHide = menu.findItem(R.id.func2)
        menuItemToHide?.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
    private fun validar():Boolean{
        if (edtAltura.text.isEmpty()||edtLargura.text.isEmpty()||edtComprimento.text.isEmpty()){
            Toast.makeText(this, "Não é possivel fazer o calculo com campos em branco", Toast.LENGTH_SHORT).show()
            edtAltura.text = ""
            edtLargura.text = ""
            edtComprimento.text = ""
            return true

        }else if(edtAltura.text.toString().toDouble() <= 0.0||edtLargura.text.toString().toDouble() <= 0.0||edtComprimento.text.toString().toDouble() <= 0.0){
            Toast.makeText(this, "Não é possivel fazer o calculo com um dos campos com numero negativo ou zero", Toast.LENGTH_SHORT).show()
            edtAltura.text = ""
            edtLargura.text = ""
            edtComprimento.text = ""
            return true
        }
        return false
    }
    private fun calcular(){
        var volume = (edtAltura.text.toString().toDouble() * edtLargura.text.toString().toDouble() * edtComprimento.text.toString().toDouble())
        val formattedVolume = String.format("%.2f", volume)
        text.text = "Volume: $formattedVolume"
        edtAltura.text = ""
        edtLargura.text = ""
        edtComprimento.text = ""
    }
    private lateinit var edtAltura:TextView
    private lateinit var edtLargura:TextView
    private lateinit var edtComprimento:TextView
    private lateinit var btn:Button
    private lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade002)
        setSupportActionBar(findViewById(R.id.toolbar))
        edtAltura = findViewById(R.id.Atv02Altura)
        edtLargura = findViewById(R.id.Atv02Largura)
        edtComprimento = findViewById(R.id.Atv02Comprimento)
        btn = findViewById(R.id.Atv02Btn)
        text = findViewById(R.id.Atv02Message)
        btn.setOnClickListener {
            if(validar()){

            }else{
                calcular()
            }
        }
    }
}