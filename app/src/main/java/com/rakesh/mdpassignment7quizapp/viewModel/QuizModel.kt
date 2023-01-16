package com.rakesh.mdpassignment7quizapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakesh.mdpassignment7quizapp.data.Quiz
import com.rakesh.mdpassignment7quizapp.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizModel @Inject constructor(
    private val repository: QuizRepository
) : ViewModel(){

    private val _data: MutableLiveData<List<Quiz>> = MutableLiveData()
    val data: LiveData<List<Quiz>> = _data

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(repository.getQuizList())
        }
    }

    fun resetDatabase(newList: MutableList<Quiz>) {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(newList)
        }
    }

    fun saveUserAnswer(quiz: Quiz) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuiz(quiz)
        }
    }
}