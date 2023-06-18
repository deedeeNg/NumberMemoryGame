package com.example.numbermemorygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var answer = intent.getStringExtra("answer")

        val input : EditText = findViewById<EditText>(R.id.input)

        val button = findViewById<Button>(R.id.button3)
        button.setOnClickListener{
            val Intent = Intent(this,MainActivity4::class.java)
            Intent.putExtra("answer", answer)
            Intent.putExtra("input", input.text.toString())
            startActivity(Intent)
            finish()
        }
    }
}