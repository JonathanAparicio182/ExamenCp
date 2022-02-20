package com.superhero.examencoppel.data.network

import com.superhero.examencoppel.common.Constantes
import com.superhero.examencoppel.data.model.PersonajesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroApiClient {
    @GET("/v1/public/characters")
    suspend fun getAllPersonajes(
        @Query("apikey")apikey: String = Constantes.API_KEY,
        @Query("ts")ts: String = Constantes.timeStamp,
        @Query("hash")hash: String = Constantes.hash(),
        @Query("offset")offset: Int
    ):Response<PersonajesModel>
}