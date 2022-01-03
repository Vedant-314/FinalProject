package com.example.FinalApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    private lateinit var  topAnimation: Animation

    private lateinit var imageView: ImageView
    private lateinit var title_txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        //val actionBar = supportActionBar
        //actionBar!!.hide()

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation)

        imageView = findViewById(R.id.hr_image)
        title_txt = findViewById(R.id.title_text)

        imageView.animation = topAnimation

        Handler().postDelayed({
            val intent=Intent(this,SecondActivity::class.java)
            startActivity(intent)
            finish()
        },5000)
        }



    }
