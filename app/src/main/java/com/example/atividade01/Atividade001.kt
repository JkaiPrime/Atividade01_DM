package com.example.atividade01


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class Atividade001 : MainActivity() {
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
        val menuItemToHide = menu.findItem(R.id.func1)
        menuItemToHide?.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
    private lateinit var edtSalario:TextView
    private lateinit var edtPorcentagem:TextView
    private lateinit var btn: Button
    private lateinit var txt:TextView

    private fun validar():Boolean{
        if (edtSalario.text.isEmpty()||edtPorcentagem.text.isEmpty()){
            Toast.makeText(this, "Não é possivel fazer o calculo com campos em branco", Toast.LENGTH_SHORT).show()
            edtSalario.text = ""
            edtPorcentagem.text = ""
            return true

        }else if(edtSalario.text.toString().toDouble()<=0.0||edtPorcentagem.text.toString().toDouble()<= 0.0){
            Toast.makeText(this, "Não é possivel fazer o calculo com um dos campos com numero negativo ou zero", Toast.LENGTH_SHORT).show()
            edtSalario.text = ""
            edtPorcentagem.text = ""
            return true
        }
        return false
    }
    private fun calcular(){
        var aumento = (edtSalario.text.toString().toDouble() * edtPorcentagem.text.toString().toDouble())/100
        val novoSalario = edtSalario.text.toString().toDouble() + aumento
        txt.text = "Aumento: $aumento\nNovo Salario: $novoSalario"
        edtSalario.text = ""
        edtPorcentagem.text = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade001)
        setSupportActionBar(findViewById(R.id.toolbar))
        edtSalario = findViewById(R.id.Atv01Salario)
        edtPorcentagem = findViewById(R.id.Atv01Porcentagem)
        btn = findViewById(R.id.Atv01Btn)
        txt = findViewById(R.id.Atv01Message)
        btn.setOnClickListener {
            if(validar()){

            }else{
                calcular()
            }
        }
    }
}