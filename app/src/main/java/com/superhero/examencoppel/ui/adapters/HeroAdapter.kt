package com.superhero.examencoppel.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.superhero.examencoppel.databinding.ItemHeroeBinding
import com.superhero.examencoppel.domain.SuperHero

class HeroAdapter(val listener: (SuperHero) -> Unit): ListAdapter<SuperHero,RecyclerView.ViewHolder>(DiffUtilCallback) {
    inner class HeroViewHolder(val binding: ItemHeroeBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: SuperHero, listener: (SuperHero) -> Unit) = with(itemView){
            val url = "${item.img}.${item.ext}".replace("http","https")
            Picasso.get().load(url).into(binding.ivHero)
            binding.tvNameHero.text = item.name
            binding.container.setOnClickListener { listener(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemHeroeBinding = ItemHeroeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is HeroViewHolder -> holder.bind(getItem(position),listener)
        }
    }
}
private object DiffUtilCallback: DiffUtil.ItemCallback<SuperHero>(){
    override fun areItemsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem == newItem
    }

}