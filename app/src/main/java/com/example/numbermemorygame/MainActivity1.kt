package com.example.numbermemorygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val actButton = findViewById<Button>(R.id.startbutton)
        actButton.setOnClickListener {
            var radio_group = findViewById<RadioGroup>(R.id.radio_group)

            var id: Int = radio_group.checkedRadioButtonId

            // Get the instance of radio button using id
            val radio: RadioButton = findViewById(id)

            val Intent = Intent(this, MainActivity2::class.java)

            val pref = applicationContext.getSharedPreferences("MyPrefs", 0) // 0 - for private mode
            val editor = pref.edit()
            editor.putString("difficulty", radio.text.toString());
            editor.commit();

            //Intent.putExtra("difficulty", )
            startActivity(Intent)
            finish()
        }

        val exitButton = findViewById<Button>(R.id.exitButton)
        exitButton.setOnClickListener {
            this.finishAffinity();
            System.exit(0);
        }

    }
}