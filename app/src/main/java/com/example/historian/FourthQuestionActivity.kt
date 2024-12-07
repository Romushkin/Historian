package com.example.historian

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FourthQuestionActivity : AppCompatActivity() {
    private lateinit var answerGroup4RG: RadioGroup
    private var result = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        answerGroup4RG = findViewById(R.id.answerGroup4RG)

        result = intent.getIntExtra("key", 0)

        answerGroup4RG.setOnCheckedChangeListener { group, checkedId ->
            val intent = Intent(this, FifthQuestionActivity::class.java)
            when (checkedId) {
                R.id.answer1Question4RB -> result += 0
                R.id.answer2Question4RB -> result += 100
                R.id.answer3Question4RB -> result += 0
            }
            intent.putExtra("key", result)
            startActivity(intent)
        }
    }
}