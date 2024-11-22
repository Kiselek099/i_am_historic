package com.example.i_am_historic

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question_3 : AppCompatActivity() {
    private lateinit var oneRB:RadioButton
    private lateinit var twoRB:RadioButton
    private lateinit var threeRB:RadioButton
    private var result:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        oneRB=findViewById(R.id.oneRB)
        twoRB=findViewById(R.id.twoRB)
        threeRB=findViewById(R.id.threeRB)
        oneRB.setOnClickListener(radioButtonSetOnClickListener)
        twoRB.setOnClickListener(radioButtonSetOnClickListener)
        threeRB.setOnClickListener(radioButtonSetOnClickListener)
        result=intent.getIntExtra("result", 0)

    }
    private val radioButtonSetOnClickListener =
        View.OnClickListener { view->
            val radioButton= view as RadioButton
            val intent=Intent(this,Question_4::class.java)
            when(radioButton.id){
                R.id.threeRB->{
                    result+=100
                }
            }
            intent.putExtra("result",result)
            startActivity(intent)
        }
}