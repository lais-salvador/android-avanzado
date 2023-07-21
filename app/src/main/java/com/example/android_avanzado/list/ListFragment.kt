package com.example.android_avanzado.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_avanzado.Model
import com.example.android_avanzado.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private  var viewModel: ListViewModel = ListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentListBinding.inflate(inflater, container, false).apply { _binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.dataList.observe(viewLifecycleOwner) {list ->
            initList(list)
        }
        viewModel.getData()
    }

    private fun initList(list: List<Model>) = binding.rvItems.run{
        adapter = ListAdapter(list)
    }

}

