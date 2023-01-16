package com.rakesh.mdpassignment7quizapp.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.OnClickListener
import androidx.lifecycle.ViewModelProvider
import com.rakesh.mdpassignment7quizapp.R
import com.rakesh.mdpassignment7quizapp.data.QuizSeedData
import com.rakesh.mdpassignment7quizapp.databinding.FragmentHomeBinding
import com.rakesh.mdpassignment7quizapp.viewModel.QuizModel
import com.rakesh.mdpassignment7quizapp.ui.SplashScreenActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), OnClickListener{

    private lateinit var _context: Context

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var viewModel: QuizModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this._context = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding = FragmentHomeBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[QuizModel::class.java]

        initialSetup()

    }

    private fun initialSetup() {
        fragmentHomeBinding.btnNext.setOnClickListener(this)
        fragmentHomeBinding.btnHome.setOnClickListener(this)

        viewModel.data.observe(viewLifecycleOwner) {quizList ->
            quizList?.let {
                val viewPagerAdapter = ViewPagerAdapter(this, it)
                fragmentHomeBinding.viewPager.adapter = viewPagerAdapter
            }
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.btn_next -> {

                fragmentHomeBinding.viewPager.setCurrentItem(fragmentHomeBinding.viewPager.currentItem + 1, true)

                //Result Fragment
                if (fragmentHomeBinding.viewPager.currentItem == 15) {
                    fragmentHomeBinding.buttonsLL.visibility = View.GONE
                    fragmentHomeBinding.viewPager.isUserInputEnabled = false
                }
            }

            R.id.btn_home -> {
                resetDatabase()
                val intent = Intent(activity, SplashScreenActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }

    private fun resetDatabase() {
        viewModel.resetDatabase(QuizSeedData.getQuestions())
    }

}