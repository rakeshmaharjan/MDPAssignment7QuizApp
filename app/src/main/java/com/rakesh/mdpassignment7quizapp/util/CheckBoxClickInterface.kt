package com.rakesh.mdpassignment7quizapp.util

import com.rakesh.mdpassignment7quizapp.data.Answer

interface CheckBoxClickInterface {
    fun onCheckBoxChecked(answer: Answer)
    fun onCheckBoxUnChecked(answer: Answer)
}