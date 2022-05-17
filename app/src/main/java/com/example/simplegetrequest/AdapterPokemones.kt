package com.example.simplegetrequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplegetrequest.databinding.PokemonesBinding
import org.json.JSONArray
import org.json.JSONObject

class AdapterPokemones(private val pokemones: JSONArray): RecyclerView.Adapter<AdapterPokemones.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPokemones.MainHolder {
        val binding = PokemonesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPokemones.MainHolder, position: Int) {
        holder.render(pokemones.getJSONObject(position))
    }

    override fun getItemCount(): Int = pokemones.length()


    class MainHolder(val binding: PokemonesBinding):RecyclerView.ViewHolder(binding.root) {
        fun render(pokemon: JSONObject){
            binding.tvPokemonName.setText(pokemon.getString("name"))
        }
    }
}