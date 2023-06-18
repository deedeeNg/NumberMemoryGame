package com.example.numbermemorygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var input = intent.getStringExtra("input")
        var answer = intent.getStringExtra("answer")

        var level = answer?.length

        val inputText : TextView = findViewById<TextView>(R.id.playerInput)
        inputText.setText(input)

        val answerText : TextView = findViewById<TextView>(R.id.correctAnswer)
        answerText.setText(answer)

        val levelText : TextView = findViewById<TextView>(R.id.levelText)

        val againButton = findViewById<Button>(R.id.playAgain)

        if (level != null) {
            levelText.setText(level.toString())

            if (input.equals(answer)) {
                level += 1
                againButton.setText("Next Level")
            }

            else {
                level = 1
                againButton.setText("Return to Main Menu")
            }
        }

        val actButton = findViewById<Button>(R.id.playAgain)
        actButton.setOnClickListener{
            if (input.equals(answer)){
                val Intent = Intent(this, MainActivity2::class.java)
                Intent.putExtra("level", level)
                startActivity(Intent)
                finish()
            }

            else{
                val Intent = Intent(this, MainActivity1::class.java)
                startActivity(Intent)
                finish()
            }


        }
    }
}