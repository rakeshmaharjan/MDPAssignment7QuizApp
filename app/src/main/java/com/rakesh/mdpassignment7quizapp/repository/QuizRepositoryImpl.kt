package com.rakesh.mdpassignment7quizapp.repository

import com.rakesh.mdpassignment7quizapp.data.Quiz
import com.rakesh.mdpassignment7quizapp.data.QuizDAO
import com.rakesh.mdpassignment7quizapp.database.QuizDatabase
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val db: QuizDatabase
) : QuizRepository {

    private var quizDao: QuizDAO = db.quizDAO

    override suspend fun insertQuestions(quizList: MutableList<Quiz>) {
        quizDao.insertQuestions(quizList)
    }

    override suspend fun insertQuiz(quiz: Quiz) {
        quizDao.insertQuiz(quiz)
    }

    override suspend fun getQuizList(): MutableList<Quiz> {
        return quizDao.getQuizList()
    }

    override suspend fun resetQuestionSet() {
        db.clearAllTables()
    }

}