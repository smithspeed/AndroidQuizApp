package com.example.androidtrivia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.androidtrivia.R
import com.example.androidtrivia.databinding.FragmentHome2Binding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHome2Binding>(inflater,R.layout.fragment_home2, container, false)

        binding.play.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment2_to_quizFragment)
        }

        return binding.root
    }
}