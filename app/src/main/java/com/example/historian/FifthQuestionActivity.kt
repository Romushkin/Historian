package com.example.historian

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FifthQuestionActivity : AppCompatActivity() {
    private lateinit var answerGroup5RG: RadioGroup
    private var result = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fifth_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        answerGroup5RG = findViewById(R.id.answerGroup5RG)

        result = intent.getIntExtra("key", 0)

        answerGroup5RG.setOnCheckedChangeListener { group, checkedId ->
            val intent = Intent(this, ResultActivity::class.java)
            when (checkedId) {
                R.id.answer1Question5RB -> result += 0
                R.id.answer2Question5RB -> result += 0
                R.id.answer3Question5RB -> result += 100
            }
            intent.putExtra("key", result)
            startActivity(intent)
        }
    }
}