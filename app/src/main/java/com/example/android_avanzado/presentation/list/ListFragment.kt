package com.example.android_avanzado.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private  val viewModel: ListViewModel by viewModels()

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

    private fun initList(list: List<HeroModel>) = binding.rvItems.run{
        adapter = ListAdapter(list)
    }

}

