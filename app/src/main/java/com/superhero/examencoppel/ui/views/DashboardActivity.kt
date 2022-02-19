package com.superhero.examencoppel.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.superhero.examencoppel.R
import com.superhero.examencoppel.databinding.ActivityDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard)
        setContentView(binding.root)

        configActivity()
    }
    private fun configActivity(){
        setSupportActionBar(binding.ToolBar)
        val navController = findNavController(R.id.navHostFragment)
        binding.ToolBar.setupWithNavController(navController)
    }
}