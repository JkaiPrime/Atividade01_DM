package com.example.atividade01

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class Atividade003 : MainActivity() {
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
        val menuItemToHide = menu.findItem(R.id.func3)
        menuItemToHide?.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
    private lateinit var edtAno:TextView
    private lateinit var btn:Button
    private lateinit var message:TextView

    private fun validar():Boolean{
        if(edtAno.text.isEmpty()){
            Toast.makeText(this, "Não é possivel fazer o calculo com campos em branco", Toast.LENGTH_SHORT).show()
            edtAno.text = ""
            return true
        }else if (edtAno.text.toString().toInt() < 1900 || edtAno.text.toString().toInt() >2023){
            Toast.makeText(this, "Ano Invalido\n Não é premitido ano abaixo de 1900 e acima de 2023", Toast.LENGTH_SHORT).show()
            edtAno.text = ""
            return true
        }
        return false
    }
    private fun calcular(){
        val idade = 2023 - edtAno.text.toString().toInt()
        message.text = "Idade: $idade"
        edtAno.text = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade003)
        setSupportActionBar(findViewById(R.id.toolbar))
        edtAno = findViewById(R.id.Atv03Ano)
        btn = findViewById(R.id.Atv03Btn)
        message = findViewById(R.id.Atv03Message)
        btn.setOnClickListener {
            if(validar()){

            }else{
                calcular()
            }
        }
    }
}