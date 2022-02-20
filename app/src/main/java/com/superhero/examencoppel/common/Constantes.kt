package com.superhero.examencoppel.common

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constantes {
    const val TIEMPO_SPLASH = 2000
    const val URL_BASE = "https://gateway.marvel.com"
    val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
    const val API_KEY = "9ec29f0a590ce9b3bb81601299760b34"
    const val PRIVATE_KEY = "032861ce1cd7001e004d0cad77e7e01c9291616a"
    const val limit = "20"
    fun hash():String{
        val input = "$timeStamp$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }
}