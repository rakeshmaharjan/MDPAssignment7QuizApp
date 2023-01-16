package com.rakesh.mdpassignment7quizapp.util

import com.rakesh.mdpassignment7quizapp.data.Quiz

interface RadioClickInterface {
    fun onRadioButtonClicked(optionPosition: Int, userAnswerDesc: String)
}