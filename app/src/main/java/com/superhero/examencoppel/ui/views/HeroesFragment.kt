package com.superhero.examencoppel.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.superhero.examencoppel.R
import com.superhero.examencoppel.databinding.FragmentHeroesBinding
import com.superhero.examencoppel.domain.SuperHero
import com.superhero.examencoppel.ui.adapters.HeroAdapter
import com.superhero.examencoppel.ui.viewmodels.HeroesVM

class HeroesFragment : Fragment() {
    private lateinit var binding: FragmentHeroesBinding
    private val viewModel: HeroesVM by activityViewModels()
    private lateinit var recyclerAdapter: HeroAdapter
    private var listHero: List<SuperHero> = emptyList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_heroes, container, false)

        viewModel.onCreate()
        setupRecyclerView()
        setupObserver()
        configFragment()

        return binding.root
    }
    private fun setupRecyclerView(){
        recyclerAdapter = HeroAdapter{
            findNavController().navigate(R.id.action_heroesFragment_to_detailFragment)
        }
        with(binding.rvHeroes){
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }
    }
    private fun setupObserver(){
        viewModel.heroes.observe(viewLifecycleOwner){
            recyclerAdapter.submitList(it)
        }
    }
    private fun configFragment(){

    }
}