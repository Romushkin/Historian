package com.example.historian

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    private lateinit var scoreTV: TextView
    private lateinit var feedbackTV: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        scoreTV = findViewById(R.id.scoreTV)
        feedbackTV = findViewById(R.id.feedbackTV)

        val result = intent.getIntExtra("key", 0)
        scoreTV.text = "Ваш результат: $result"
        when (result) {
            200 -> feedbackTV.text = "Неудовлетворительный  результат. Нужно подтянуть знания."
            300 -> feedbackTV.text = "Удовлетворительный результат. Средний уровень знаний."
            400 -> feedbackTV.text = "Хороший результат. Хороший знаток истории!"
            500 -> feedbackTV.text = "Отличный результат. Отличный знаток истории!"
            else -> feedbackTV.text = "Плохой результат. Необходимо больше учить историю!"
        }
    }
}