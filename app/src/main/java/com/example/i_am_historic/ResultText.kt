package com.example.i_am_historic

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultText : AppCompatActivity() {
    lateinit var resultTV:TextView
    lateinit var titleTV:TextView
    private var result:Int=0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_text)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    resultTV=findViewById(R.id.resultTV)
        titleTV=findViewById(R.id.titleTV)
        result=intent.getIntExtra("result",0)
        titleTV.text="Вы набрали "+result.toString()+" очков"
        when(result){
            0->resultTV.text="Ваш уровень знаний истории России плохой! Вам нужно как следует позаниматься"
            100->resultTV.text="Ваш уровень знаний истории России неудовлетворительный! Чуть лучше, чем плохой, нужно заниматься!"
            200->resultTV.text="Ваш уровень знаний истории России удовлетворительный! Что то знаете,но на троечку("
            300->resultTV.text="Ваш уровень знаний истории России хороший! Буквально подтянуть пару вопросиков, и вы будете на высоте!"
            400->resultTV.text="Ваш уровень знаний истории России отличный! Вы прошли тест всего с одной ошибкой, так держать!"
            500->resultTV.text="Ваш уровень знаний истории России великолепный! Вы идеально справились с тестом!"
            else->""
        }

    }
}