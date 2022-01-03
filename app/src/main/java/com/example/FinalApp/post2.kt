package com.example.FinalApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class post2 : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var button1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post2)

        editText=findViewById(R.id.editTextTextPersonName)
        button1=findViewById(R.id.button)


        val clickme2=findViewById<Button>(R.id.button2)
        val clickme4=findViewById<Button>(R.id.button3)

        clickme2.setOnClickListener{
            val intent2= Intent(this,ViewScreen::class.java)
            startActivity(intent2)
        }

        clickme4.setOnClickListener{
            val intent4=Intent(this,imageGallery::class.java)
            startActivity(intent4)
        }

        button1.setOnClickListener{
            postscreen()
        }

    }

    private fun postscreen(){
        val fact= editText.text.toString().trim()

        if(fact.isEmpty())
        {
            editText.error="Please enter something!"
            return
        }


        val ref= FirebaseDatabase.getInstance().getReference("information")

        val Fid= ref!!.push().key!!
        val info= Facts(Fid,fact)

        ref.child(Fid).setValue(info).addOnCompleteListener{
            Toast.makeText(applicationContext,"Added Successfully", Toast.LENGTH_LONG).show()
        }
    }
}