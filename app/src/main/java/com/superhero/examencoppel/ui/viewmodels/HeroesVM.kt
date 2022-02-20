package com.superhero.examencoppel.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getHeroUseCase(0)
            heroes.postValue(result)
            isLoading.postValue(false)
        }
    }
}