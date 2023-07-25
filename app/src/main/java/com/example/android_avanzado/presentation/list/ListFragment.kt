package com.example.android_avanzado.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.databinding.FragmentListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private  val listViewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentListBinding.inflate(inflater, container, false).apply { _binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listViewModel.dataList.observe(viewLifecycleOwner) { list ->
            initList(list)
        }
        listViewModel.error.observe(viewLifecycleOwner) {message ->
            showError(message)
        }
        println(listViewModel.getData())
        listViewModel.getData()
    }

    private fun showError(message: String) = binding.errorText.run{
        text = message
        visibility = View.VISIBLE
    }

    private fun initList(list: List<HeroModel>) = binding.rvItems.run{
        adapter = ListAdapter(list)
    }

}

