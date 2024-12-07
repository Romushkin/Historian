package com.example.historian

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondQuestionActivity : AppCompatActivity() {
    private lateinit var answerGroup2RG: RadioGroup
    private var result = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        answerGroup2RG = findViewById(R.id.answerGroup2RG)

        result = intent.getIntExtra("key", 0)

        answerGroup2RG.setOnCheckedChangeListener { group, checkedId ->
            val intent = Intent(this, ThirdQuestionActivity::class.java)
            when (checkedId) {
                R.id.answer1Question2RB -> result += 0
                R.id.answer2Question2RB -> result += 100
                R.id.answer3Question2RB -> result += 0
            }
            intent.putExtra("key", result)
            startActivity(intent)
        }
    }
}