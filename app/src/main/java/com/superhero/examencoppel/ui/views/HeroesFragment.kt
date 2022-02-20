package com.superhero.examencoppel.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.superhero.examencoppel.R
import com.superhero.examencoppel.databinding.FragmentHeroesBinding
import com.superhero.examencoppel.domain.SuperHero
import com.superhero.examencoppel.ui.adapters.HeroAdapter

class HeroesFragment : Fragment() {
    private lateinit var binding: FragmentHeroesBinding
    private lateinit var recyclerAdapter: HeroAdapter
    private var listHero = mutableListOf(
        SuperHero("https://i0.wp.com/hipertextual.com/wp-content/uploads/2019/09/hipertextual-deadpool-podria-aparecer-thor-love-and-thunder-2019036450.jpg?fit=2176%2C1464&ssl=1","Dead pool"),
        SuperHero("https://i0.wp.com/hipertextual.com/wp-content/uploads/2019/09/hipertextual-deadpool-podria-aparecer-thor-love-and-thunder-2019036450.jpg?fit=2176%2C1464&ssl=1","Batman"),
        SuperHero("https://i0.wp.com/hipertextual.com/wp-content/uploads/2019/09/hipertextual-deadpool-podria-aparecer-thor-love-and-thunder-2019036450.jpg?fit=2176%2C1464&ssl=1","Spiderman"),
        SuperHero("https://i0.wp.com/hipertextual.com/wp-content/uploads/2019/09/hipertextual-deadpool-podria-aparecer-thor-love-and-thunder-2019036450.jpg?fit=2176%2C1464&ssl=1","Acuaman"),
        SuperHero("https://i0.wp.com/hipertextual.com/wp-content/uploads/2019/09/hipertextual-deadpool-podria-aparecer-thor-love-and-thunder-2019036450.jpg?fit=2176%2C1464&ssl=1","Punisher"),
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_heroes, container, false)

        setupRecyclerView()
        configFragment()
        recyclerAdapter.submitList(listHero)

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
    private fun configFragment(){

    }
}