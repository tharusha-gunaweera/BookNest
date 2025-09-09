package com.example.booknest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    private lateinit var btnProceedToPayment: Button
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)


        ivBack = findViewById(R.id.ivBack)


        ivBack.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        btnProceedToPayment = findViewById(R.id.btnProceedToPayment)



    }
}