package com.superhero.examencoppel.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Picasso
import com.superhero.examencoppel.R
import com.superhero.examencoppel.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)

        configFragment()

        return binding.root
    }
    private fun configFragment(){
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        Picasso.get().load(args.img).into(binding.ivSuperHero)
        binding.tvName.text = args.name
        binding.tvDescrip.text = args.desc
        binding.tvSinDescrip.isVisible = args.desc.isEmpty()
    }
}