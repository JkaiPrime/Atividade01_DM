package com.example.atividade01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Atividade003 : MainActivity() {
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
        R.id.func4 ->{
            Toast.makeText(this, "Atividade 04", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.func5 ->{
            Toast.makeText(this, "Atividade 05", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.func6 ->{
            Toast.makeText(this, "Atividade 06", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.func7 ->{
            Toast.makeText(this, "Atividade 07", Toast.LENGTH_SHORT).show()
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
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atividade003)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}