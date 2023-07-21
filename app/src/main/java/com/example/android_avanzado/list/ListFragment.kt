package com.example.android_avanzado.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_avanzado.Model
import com.example.android_avanzado.R
import com.example.android_avanzado.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: ItemAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        initRecyclerView()
        getItems()
        return binding.root
    }
    private fun initRecyclerView(){
        binding.rvItems.layoutManager = LinearLayoutManager(context)
        adapter = ItemAdapter()
        binding.rvItems.adapter = adapter
    }
    private fun getItems(){
        val modelList = List<Model>(10){
            Model.dummy()
        }
        adapter.setItems(modelList)
    }
}

