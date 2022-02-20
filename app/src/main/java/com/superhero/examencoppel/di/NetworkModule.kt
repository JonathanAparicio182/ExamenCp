package com.superhero.examencoppel.di

import com.superhero.examencoppel.common.Constantes
import com.superhero.examencoppel.data.network.HeroApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constantes.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideHeroApiClient(retrofit: Retrofit):HeroApiClient{
        return retrofit.create(HeroApiClient::class.java)
    }
}