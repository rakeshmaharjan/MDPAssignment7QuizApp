package com.rakesh.mdpassignment7quizapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rakesh.mdpassignment7quizapp.data.Quiz
import com.rakesh.mdpassignment7quizapp.data.QuizDAO
import com.rakesh.mdpassignment7quizapp.util.Converter

@Database(
    entities = [Quiz::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class QuizDatabase: RoomDatabase() {
    abstract val quizDAO: QuizDAO
}