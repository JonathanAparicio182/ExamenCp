package com.superhero.examencoppel.data

import com.superhero.examencoppel.data.network.HeroService
import com.superhero.examencoppel.domain.SuperHero
import com.superhero.examencoppel.domain.toDomain
import javax.inject.Inject

class HeroRepository @Inject constructor(
    private val api: HeroService
    ) {
    suspend fun getHeroFromApi(offset: Int): List<SuperHero>{
        val response = api.getAllPersonajes(offset)
        return response?.data?.results?.map { it.toDomain() } ?: emptyList()
    }
}