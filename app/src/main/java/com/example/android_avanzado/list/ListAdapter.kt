package com.example.android_avanzado.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_avanzado.Model
import com.example.android_avanzado.databinding.ListItemBinding

class ListAdapter(
    private val itemList: List<Model>
): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        val tvNombre = binding.text
        val tvImage = binding.image

        fun bind(item: Model){
            tvNombre.text = item.name
            Glide.with(binding.root.context)
                .load(item.photoUrl)
                .into(tvImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(itemList[position])
    }
}

