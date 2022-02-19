package com.superhero.examencoppel.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.superhero.examencoppel.R
import com.superhero.examencoppel.databinding.FragmentHeroesBinding

class HeroesFragment : Fragment() {
    private lateinit var binding: FragmentHeroesBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_heroes, container, false)

        configFragment()

        return binding.root
    }
    private fun configFragment(){
        binding.button.setOnClickListener { findNavController().navigate(R.id.action_heroesFragment_to_detailFragment) }
    }
}