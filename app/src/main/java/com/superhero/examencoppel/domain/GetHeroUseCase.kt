package com.superhero.examencoppel.domain

import com.superhero.examencoppel.data.HeroRepository
import javax.inject.Inject

class GetHeroUseCase @Inject constructor(private val repository: HeroRepository) {
    suspend operator fun invoke(offset: Int): List<SuperHero>{
        return repository.getHeroFromApi(offset)
    }
}