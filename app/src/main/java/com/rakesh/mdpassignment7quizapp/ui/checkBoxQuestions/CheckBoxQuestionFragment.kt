package com.rakesh.mdpassignment7quizapp.ui.checkBoxQuestions

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rakesh.mdpassignment7quizapp.R
import com.rakesh.mdpassignment7quizapp.data.Answer
import com.rakesh.mdpassignment7quizapp.data.Quiz
import com.rakesh.mdpassignment7quizapp.databinding.FragmentCheckBoxQuestionBinding
import com.rakesh.mdpassignment7quizapp.viewModel.QuizModel
import com.rakesh.mdpassignment7quizapp.util.CheckBoxClickInterface
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckBoxQuestionFragment : Fragment(R.layout.fragment_check_box_question), CheckBoxClickInterface {

    private lateinit var quiz: Quiz
    private lateinit var quizModel: QuizModel
    private lateinit var binding: FragmentCheckBoxQuestionBinding
    private var checkedOptions: ArrayList<Answer> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentsData()

        initialSetup(view)
    }

    private fun getArgumentsData() {
        arguments?.let {
            quiz = Gson().fromJson(it.getString("quiz"), Quiz::class.java)
        }
    }

    private fun initialSetup(view: View) {
        binding = FragmentCheckBoxQuestionBinding.bind(view)
        quizModel = ViewModelProvider(requireActivity())[QuizModel::class.java]

        binding.tvQuestion.text = quiz.question

        //initializing recycler view
        val adapter = CBQuestionAdapter(quiz.options, this)
        binding.rvOptions.adapter = adapter
    }

    override fun onCheckBoxChecked(answer: Answer) {
        checkedOptions.add(answer)
    }

    override fun onCheckBoxUnChecked(answer: Answer) {
        checkedOptions.remove(answer)
    }

    override fun onPause() {
        super.onPause()
        var answer = ""
        var answerDesc = ""
        checkedOptions.sortedBy { it.option }
        checkedOptions.forEach { answerModel ->
            answer += when (answerModel.option) {
                0 -> "a"
                1 -> "b"
                2 -> "c"
                3 -> "d"
                else -> ""
            }
            answerDesc += answerModel.description+"\n"
        }

        //update the answer parameter of quiz object
        quiz.userAnswer = answer
        quiz.userAnswerDesc = answerDesc
        quizModel.saveUserAnswer(quiz)
        Log.v("CheckBoxQuestionFragment", "inserted data : $quiz")
    }

    companion object {

        @JvmStatic
        fun newInstance(quiz: String) = CheckBoxQuestionFragment().apply {
            arguments = Bundle().apply {
                putString("quiz", quiz)
            }
        }
    }
}