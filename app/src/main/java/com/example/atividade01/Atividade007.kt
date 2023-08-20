package com.example.atividade01

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlin.math.PI

class Atividade007 : MainActivity() {

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
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val menuItemToHide = menu.findItem(R.id.func7)
        menuItemToHide?.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
    private lateinit var edtRaio:TextView
    private lateinit var edtAltura:TextView
    private lateinit var btn: Button
    private lateinit var message: TextView

    private fun validar(): Boolean {
        if (edtRaio.text.isEmpty()||edtAltura.text.isEmpty()){
            Toast.makeText(this, "Não é possivel fazer o calculo com campos em branco", Toast.LENGTH_SHORT).show()
            edtRaio.text = ""
            edtAltura.text = ""
            return true

        }else if(edtRaio.text.toString().toDouble()<=0.0||edtAltura.text.toString().toDouble()<= 0.0){
            Toast.makeText(this, "Não é possivel fazer o calculo com um dos campos com numero negativo ou zero", Toast.LENGTH_SHORT).show()
            edtRaio.text = ""
            edtAltura.text = ""
            return true
        }
        return false
    }
    private fun calcular(){
        val volume = PI * edtRaio.text.toString().toDouble() * edtRaio.text.toString().toDouble() * edtAltura.text.toString().toDouble()
        val formattedVolume = String.format("%.2f", volume)
        message.text = "Volume: $formattedVolume"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade007)
        setSupportActionBar(findViewById(R.id.toolbar))
        edtRaio = findViewById(R.id.Atv07RaioBase)
        edtAltura = findViewById(R.id.Atv07Altura)
        btn = findViewById(R.id.Atv07Btn)
        message =findViewById(R.id.Atv07Message)
        btn.setOnClickListener {
            if (validar()){

            }else{
                calcular()
            }
        }
    }
}