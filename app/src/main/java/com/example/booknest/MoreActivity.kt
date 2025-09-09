package com.example.booknest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottomNavigationView.selectedItemId = R.id.menu_more


        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_inventory -> {

                    val intent = Intent(this, InventoryActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_more -> {

                    true
                }
                else -> false
            }
        }
    }
}
