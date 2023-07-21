package com.example.android_avanzado.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_avanzado.Model
import com.example.android_avanzado.databinding.ListItemBinding

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    lateinit var binding: ListItemBinding
    private var itemList: MutableList<Model> = mutableListOf()

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvNombre = binding.text
        val tvImage = binding.image

        fun bind(binding: ListItemBinding, item: Model){
            tvNombre.text = item.name
            //Insertar una imagen desde el binding
            Glide.with(binding.root.context)
                .load(item.photoUrl)
                .into(tvImage)        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder((binding.root))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = itemList[position]
        holder.bind(binding, item)
    }

    fun setItems(modelList: List<Model>){
        itemList = modelList.toMutableList()
        notifyDataSetChanged()
    }
}

