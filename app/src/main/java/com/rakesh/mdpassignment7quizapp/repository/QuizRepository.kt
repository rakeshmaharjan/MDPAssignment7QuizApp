package com.rakesh.mdpassignment7quizapp.repository

import com.rakesh.mdpassignment7quizapp.data.Quiz

interface QuizRepository {
    suspend fun insertQuestions(quizList : MutableList<Quiz>)
    suspend fun insertQuiz(quiz: Quiz)
    suspend fun getQuizList(): MutableList<Quiz>
    suspend fun resetQuestionSet()
}