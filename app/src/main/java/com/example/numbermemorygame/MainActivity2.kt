package com.example.numbermemorygame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private val handler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var level = intent.getIntExtra("level", 1)
        var answer = ""
        var progressStatus = 0

        for (i in 1..level){
            answer += (0..9).random().toString()
        }

        val answerText : TextView = findViewById<TextView>(R.id.answer)

        answerText.setText(answer)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        Thread {
            while (progressStatus < 100) {
                progressStatus += 1
                // Update the progress bar and display the
                //current value in the text view
                handler.post(Runnable {
                    progressBar.progress = progressStatus
                })
                try {
                    // Sleep for 100 milliseconds.
                    Thread.sleep(50)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            val Intent = Intent(this,MainActivity3::class.java)
            Intent.putExtra("answer", answer)
            startActivity(Intent)
            finish()
        }.start()

    }
}