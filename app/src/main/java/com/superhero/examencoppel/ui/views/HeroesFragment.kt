package com.superhero.examencoppel.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.superhero.examencoppel.R
import com.superhero.examencoppel.databinding.FragmentHeroesBinding
import com.superhero.examencoppel.ui.adapters.HeroAdapter
import com.superhero.examencoppel.ui.viewmodels.HeroesVM

class HeroesFragment : Fragment() {
    private lateinit var binding: FragmentHeroesBinding
    private val viewModel: HeroesVM by activityViewModels()
    private lateinit var recyclerAdapter: HeroAdapter
    private var isScrolling = false
    private var currentItems = 0
    private var totalItems = 0
    private var scrollOutItems = 0
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
            findNavController().navigate(HeroesFragmentDirections.actionHeroesFragmentToDetailFragment(
                it.id,
                it.name,
                it.desc,
                "${it.img}.${it.ext}".replace("http","https"),
                it.comics.toTypedArray()
            ))
        }
        val manager = LinearLayoutManager(context)
        with(binding.rvHeroes){
            layoutManager = manager
            adapter = recyclerAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                        isScrolling = true
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    currentItems = manager.childCount+2
                    totalItems = manager.itemCount
                    scrollOutItems = manager.findFirstVisibleItemPosition()
                    if (isScrolling && (currentItems + scrollOutItems >= totalItems)){
                        isScrolling = false
                        viewModel.loadNext(recyclerAdapter.currentList.toMutableList())
                    }
                    else if (isScrolling && scrollOutItems <= 2){
                        isScrolling = false
                        viewModel.loadPrev()
                    }
                }
            })
        }
    }
    private fun setupObserver(){
        viewModel.heroes.observe(viewLifecycleOwner){
            recyclerAdapter.submitList(it)
        }
        viewModel.isLoading.observe(viewLifecycleOwner){
            binding.pbLoading.isVisible = it
        }
    }
    private fun configFragment(){

    }
}