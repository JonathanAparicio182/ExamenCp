package com.superhero.examencoppel.domain

import android.graphics.drawable.Drawable
import com.superhero.examencoppel.data.model.Result

data class SuperHero(
    val id: Int,
    val name: String,
    val desc: String,
    val img: String,
    val ext: String,
    val comics: List<String>
)

fun Result.toDomain() = SuperHero(
    id = id,
    name = name,
    desc = description,
    img = thumbnail.path,
    ext = thumbnail.extension,
    comics = comics.items.map {
        it.name
    }
)
