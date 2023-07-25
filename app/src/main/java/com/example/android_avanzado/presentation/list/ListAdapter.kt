package com.example.android_avanzado.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.databinding.ListItemBinding

class ListAdapter(
    private val itemList: List<HeroModel>,
    private val onClick: (HeroModel) -> Unit
     ): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        val tvNombre = binding.text
        val tvImage = binding.image

        fun bind(item: HeroModel, onClick: (HeroModel) -> Unit){
            tvNombre.text = item.name
            Glide.with(binding.root.context)
                .load(item.photoUrl)
                .into(tvImage)
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        /*holder.bind(itemList[position]){
            onClick.invoke(it)
        }*/

        holder.bind(itemList[position], onClick)
    }
}

