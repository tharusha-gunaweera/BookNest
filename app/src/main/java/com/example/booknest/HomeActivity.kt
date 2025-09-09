package com.example.booknest

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var ivFirstBook: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        ivFirstBook = findViewById(R.id.firstImg)

        ivFirstBook.setOnClickListener {

            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {

                    true
                }
                R.id.menu_inventory -> {

                    val intent = Intent(this, InventoryActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_more -> {

                    val intent = Intent(this, MoreActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
