package com.example.FinalApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val clickme1=findViewById<Button>(R.id.pbutton1)
        val clickme3=findViewById<Button>(R.id.pbutton2)
        val clickme4=findViewById<Button>(R.id.button3)

        clickme1.setOnClickListener{
            val intent1=Intent(this,post1::class.java)
            startActivity(intent1)
        }

        clickme3.setOnClickListener{
            val intent3=Intent(this,post2::class.java)
            startActivity(intent3)
        }




    }
}