package com.superhero.examencoppel.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.superhero.examencoppel.R
import com.superhero.examencoppel.common.Constantes
import com.superhero.examencoppel.databinding.ActivitySplashBinding
import com.superhero.examencoppel.ui.views.DashboardActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        setContentView(binding.root)

        configActivity()
    }
    private fun configActivity(){
        binding.tvTitulo.alpha = 0f
        binding.tvAuthor.alpha = 0f
        binding.tvTitulo.animate().setDuration(Constantes.TIEMPO_SPLASH.toLong()).alpha(1f)
        binding.tvAuthor.animate().setDuration(Constantes.TIEMPO_SPLASH.toLong()).alpha(1f).withEndAction {
            val principal = Intent(binding.root.context,DashboardActivity::class.java)
            startActivity(principal)
            finish()
        }
    }
}