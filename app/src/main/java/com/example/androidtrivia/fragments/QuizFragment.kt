package com.example.androidtrivia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.androidtrivia.R
import com.example.androidtrivia.databinding.FragmentQuizBinding
import java.lang.reflect.Array


class QuizFragment : Fragment() {

    data class Questions(
        val text: String,
        val answers : List<String>
    )

    private val questions : MutableList<Questions> = mutableListOf(
        Questions(
            text = "What is Android Development1 ??",
            answers = listOf("Option 1", "Option 2", "Option 3", "Option 4")
        ),
        Questions(
            text = "What is Android Development2 ??",
            answers = listOf("Option 1", "Option 2", "Option 3", "Option 4")
        ),
        Questions(
            text = "What is Android Development3 ??",
            answers = listOf("Option 1", "Option 2", "Option 3", "Option 4")
        ),
        Questions(
            text = "What is Android Development4 ??",
            answers = listOf("Option 1", "Option 2", "Option 3", "Option 4")
        ),
    )

    lateinit var currentQuestion : Questions
    lateinit var answers : MutableList<String>

    private var questionIndex = 0
    private val totalQuestion = 4

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(inflater, R.layout.fragment_quiz, container, false)

        binding.questions = this

        randomizeQuestion()

        binding.submitBtn.setOnClickListener {
            val checkId = binding.radioGroup.checkedRadioButtonId

            if(checkId !=-1){

                var answerIndex = 0;

                when(checkId) {
                    R.id.answerSecond -> answerIndex = 1
                    R.id.answerThird -> answerIndex = 2
                    R.id.answerFourth -> answerIndex = 3
                }

                if(answers[answerIndex] == currentQuestion.answers[0]){

                    questionIndex ++

                    if(questionIndex < totalQuestion){

                        currentQuestion = questions[questionIndex]
                        setQuestion()

                        binding.invalidateAll()
                    }
                    else{
                        it.findNavController().navigate(R.id.action_quizFragment_to_quizWinFragment)
                    }
                }
                else{

                    it.findNavController().navigate(R.id.action_quizFragment_to_quizOverFragment)
                }
            }
        }


        return binding.root
    }

    private fun randomizeQuestion() {

        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }
}