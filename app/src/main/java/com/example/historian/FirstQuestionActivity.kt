package com.example.historian

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstQuestionActivity : AppCompatActivity() {

    private lateinit var answerGroup1RG: RadioGroup
    private var result = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        answerGroup1RG = findViewById(R.id.answerGroup1RG)
        answerGroup1RG.setOnCheckedChangeListener { group, checkedId ->
            val intent = Intent(this, SecondQuestionActivity::class.java)
            when (checkedId) {
                R.id.answer1Question1RB -> result += 0
                R.id.answer2Question1RB -> result += 100
                R.id.answer3Question1RB -> result += 0
            }
            intent.putExtra("key", result)
            startActivity(intent)
        }
    }
}