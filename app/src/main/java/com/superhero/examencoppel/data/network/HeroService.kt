package com.superhero.examencoppel.data.network

import com.superhero.examencoppel.data.model.PersonajesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HeroService @Inject constructor(private val api: HeroApiClient) {
    suspend fun getAllPersonajes(offset:Int): PersonajesModel?{
        return withContext(Dispatchers.IO){
            val response = api.getAllPersonajes(offset = offset)
            response.body()
        }
    }
}