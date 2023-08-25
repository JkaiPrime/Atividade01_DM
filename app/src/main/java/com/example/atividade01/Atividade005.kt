package com.example.atividade01

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class Atividade005 : MainActivity() {
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
        val menuItemToHide = menu.findItem(R.id.func5)
        menuItemToHide?.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
    private lateinit var edtNota1 :TextView
    private lateinit var edtNota2 :TextView
    private lateinit var edtNota3:TextView
    private lateinit var edtNota4 :TextView
    private lateinit var btn:Button
    private lateinit var message:TextView
    private fun validar(): Boolean {
        if(edtNota1.text.isEmpty() ||edtNota2.text.isEmpty() ||edtNota3.text.isEmpty() ||edtNota4.text.isEmpty()){
            Toast.makeText(this, "Não é possivel fazer o calculo com campos em branco", Toast.LENGTH_SHORT).show()
            edtNota2.text = ""
            edtNota1.text = ""
            edtNota3.text = ""
            edtNota4.text = ""
            return true
        }else if(edtNota1.text.toString().toDouble() <0 ||edtNota2.text.toString().toDouble() <0 ||edtNota3.text.toString().toDouble() <0 ||edtNota4.text.toString().toDouble() <0){
            Toast.makeText(this, "Não é possivel fazer o calculo com um dos campos com numero negativo", Toast.LENGTH_SHORT).show()
            edtNota2.text = ""
            edtNota1.text = ""
            edtNota3.text = ""
            edtNota4.text = ""
            return true
        }else if(edtNota1.text.toString().toDouble() >0 ||edtNota2.text.toString().toDouble() <10.0 ||edtNota3.text.toString().toDouble() >10.0 ||edtNota4.text.toString().toDouble() <0) {
            Toast.makeText(
                this,
                "Não é possivel fazer o calculo com um dos campos com numero maior que 10",
                Toast.LENGTH_SHORT
            ).show()
            edtNota2.text = ""
            edtNota1.text = ""
            edtNota3.text = ""
            edtNota4.text = ""
            return true
        }
        return false
    }
    private fun calcular(){
        val media = (edtNota1.text.toString().toDouble() + edtNota2.text.toString().toDouble()+ edtNota3.text.toString().toDouble()+ edtNota4.text.toString().toDouble())/4
        message.text = "Media Final: $media"
        edtNota2.text = ""
        edtNota1.text = ""
        edtNota3.text = ""
        edtNota4.text = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade005)
        setSupportActionBar(findViewById(R.id.toolbar))
        message = findViewById(R.id.Atv05Message)
        btn = findViewById(R.id.Atv05Btn)
        edtNota1 = findViewById(R.id.Atv05Nota1)
        edtNota2 = findViewById(R.id.Atv05Nota2)
        edtNota3 = findViewById(R.id.Atv05Nota3)
        edtNota4 = findViewById(R.id.Atv05Nota4)
        btn.setOnClickListener {
            if(validar()){

            }else{
                calcular()
            }
        }

    }
}