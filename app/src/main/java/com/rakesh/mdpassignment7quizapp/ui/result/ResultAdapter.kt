package com.rakesh.mdpassignment7quizapp.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.mdpassignment7quizapp.R
import com.rakesh.mdpassignment7quizapp.data.Quiz
import com.rakesh.mdpassignment7quizapp.databinding.ItemResultAnalysisBinding
import com.rakesh.mdpassignment7quizapp.util.DiffUtilCallbackImpl

class ResultAdapter(
    private val quizList: MutableList<Quiz> = mutableListOf()
): RecyclerView.Adapter<ResultAdapter.ResultAnalysisViewHolder>() {

    inner class ResultAnalysisViewHolder(private val binding: ItemResultAnalysisBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(quiz: Quiz) {
            binding.quiz = quiz
        }
    }

    fun updateList(newList: List<Quiz>) {
        val result = DiffUtil.calculateDiff(DiffUtilCallbackImpl(quizList, newList))
        quizList.clear()
        quizList.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultAnalysisViewHolder {
        val binding = ItemResultAnalysisBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_result_analysis, parent, false))
        return ResultAnalysisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultAnalysisViewHolder, position: Int) {
        holder.bind(quizList[position])
    }

    override fun getItemCount(): Int = quizList.size
}