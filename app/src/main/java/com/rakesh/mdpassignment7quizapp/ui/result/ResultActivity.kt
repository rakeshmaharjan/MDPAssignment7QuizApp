package com.rakesh.mdpassignment7quizapp.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.rakesh.mdpassignment7quizapp.R
import com.rakesh.mdpassignment7quizapp.databinding.ActivityResultBinding
import com.rakesh.mdpassignment7quizapp.viewModel.QuizModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultActivity : AppCompatActivity(R.layout.activity_result) {

    private lateinit var binding : ActivityResultBinding
    private val viewModel: QuizModel by viewModels()
    private lateinit var adapter: ResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        loadData()
    }

    private fun initRecyclerView() {
        adapter = ResultAdapter()
        binding.resultAnalysisRecyclerView.adapter = adapter
    }

    private fun loadData() {
        viewModel.data.observe(this){quizList ->
            quizList?.let {
                adapter.updateList(it)
            }
        }
    }
}