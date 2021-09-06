package com.aransafp.rickandmor.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aransafp.rickandmor.data.response.Character
import com.aransafp.rickandmor.databinding.ItemCharacterBinding
import com.bumptech.glide.Glide

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val listCharacters = ArrayList<Character>()

    fun setData(characters: List<Character>?) {
        if (characters == null) return
        listCharacters.clear()
        listCharacters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listCharacters[position])
    }

    override fun getItemCount(): Int = listCharacters.size

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            with(binding) {

                tvName.text = character.name
                tvOrigin.text = character.origin.name
                tvLocation.text = character.location.name

                Glide.with(itemView.context)
                    .load(character.image)
                    .into(imgAvatar)

            }
        }

    }
}