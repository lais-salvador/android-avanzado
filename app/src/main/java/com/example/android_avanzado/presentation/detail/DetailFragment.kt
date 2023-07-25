package com.example.android_avanzado.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.android_avanzado.databinding.ItemDetailBinding
import com.example.android_avanzado.domain.model.HeroModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: ItemDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = ItemDetailBinding.inflate(inflater, container, false).apply { _binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel.heroModel.observe(viewLifecycleOwner) { hero ->
            setUpViews(hero)
        }
        detailViewModel.getHeroDetailById(args.heroId)
    }

    private fun setUpViews(hero: HeroModel) {
        binding.tvName.text = hero.name
        binding.tvDescription.text = hero.description
        Glide.with(binding.root.context)
            .load(hero.photoUrl)
            .into(binding.ivHero)
    }
}