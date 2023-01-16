package com.rakesh.mdpassignment7quizapp.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rakesh.mdpassignment7quizapp.R
import com.rakesh.mdpassignment7quizapp.constants.Constant.PREF_NAME
import com.rakesh.mdpassignment7quizapp.data.QuizSeedData
import com.rakesh.mdpassignment7quizapp.database.QuizDB
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initQuizData()
        setContentView(R.layout.activity_main)
    }

    private fun initQuizData() {
        val questions = QuizSeedData.getQuestions()
        val quizDAO = QuizDB(this).getQuizDAO()

        MainScope().launch(Dispatchers.IO) {
            quizDAO.insertQuestions(questions)
        }
    }

}