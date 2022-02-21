package com.superhero.examencoppel.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.superhero.examencoppel.domain.GetHeroUseCase
import com.superhero.examencoppel.domain.SuperHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesVM @Inject constructor(private val getHeroUseCase: GetHeroUseCase): ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val heroes = MutableLiveData<List<SuperHero>>()
    private var offset = 0
    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getHeroUseCase(offset)
            heroes.postValue(result)
            isLoading.postValue(false)
        }
    }
    fun loadPrev(){
        if (offset>0) {
            viewModelScope.launch {
                isLoading.postValue(true)
                offset -= 20
                val result = getHeroUseCase(offset)
                val prevList: MutableList<SuperHero> = mutableListOf()
                prevList.addAll(result)
                heroes.value?.forEach { prevList.add(it) }
                heroes.postValue(prevList)
                isLoading.postValue(false)
            }
        }
    }
    fun loadNext(currentList: MutableList<SuperHero>){
        viewModelScope.launch {
            isLoading.postValue(true)
            offset += 20
            val result = getHeroUseCase(offset)
            result.forEach { currentList.add(it) }
            heroes.postValue(currentList)
            isLoading.postValue(false)
        }
    }
}