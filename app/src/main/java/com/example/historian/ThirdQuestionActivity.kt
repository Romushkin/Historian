package com.example.historian

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdQuestionActivity : AppCompatActivity() {
    private lateinit var answerGroup3RG: RadioGroup
    private var result = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        answerGroup3RG = findViewById(R.id.answerGroup3RG)

        result = intent.getIntExtra("key", 0)

        answerGroup3RG.setOnCheckedChangeListener { group, checkedId ->
            val intent = Intent(this, FourthQuestionActivity::class.java)
            when (checkedId) {
                R.id.answer1Question3RB -> result += 100
                R.id.answer2Question3RB -> result += 0
                R.id.answer3Question3RB -> result += 0
            }
            intent.putExtra("key", result)
            startActivity(intent)
        }
    }
}