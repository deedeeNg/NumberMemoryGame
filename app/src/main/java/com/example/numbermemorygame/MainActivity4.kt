package com.example.numbermemorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val actButton = findViewById<Button>(R.id.playagain)
        actButton.setOnClickListener{
            val Intent = Intent(this, MainActivity2::class.java)
            startActivity(Intent)
            finish()
        }
    }
}