package com.example.atividade01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Atividade007 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.darkMode -> {
            Toast.makeText(this, "Dark Mode", Toast.LENGTH_LONG).show()
            true
        }
        R.id.lightMode->{
            Toast.makeText(this, "Light Mode", Toast.LENGTH_SHORT).show()
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
        val menuItemToHide = menu.findItem(R.id.func5)
        menuItemToHide?.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade007)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}