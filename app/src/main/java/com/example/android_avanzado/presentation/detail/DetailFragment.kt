package com.example.android_avanzado.presentation.detail

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.android_avanzado.databinding.ItemDetailBinding
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.domain.model.LocationModel
import com.google.android.gms.location.LocationServices
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: ItemDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  = ItemDetailBinding.inflate(inflater, container, false).apply { _binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel.heroModel.observe(viewLifecycleOwner) { hero ->
            setUpViews(hero)
        }
        detailViewModel.location.observe(viewLifecycleOwner) { location ->
            binding.tvDistance.text = location
        }
        detailViewModel.getData(args.heroId)
    }

    private fun setUpViews(hero: HeroModel) = binding.run {
        tvName.text = hero.name
        tvDescription.text = hero.description
        Glide.with(root.context)
            .load(hero.photoUrl)
            .into(ivHero)
    }

    private fun hasPermissions(context: Context) = ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

    @SuppressLint("MissingPermission")
    private fun getLocation(context: Context){
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        fusedLocationClient.lastLocation.addOnCompleteListener { result ->
            val lat = result.result?.latitude
            val long = result.result?.longitude
            if(result.isSuccessful && lat != null && long != null) {
                detailViewModel.setUserLocation(lat, long)
                Log.d("DetailFragment", "Lat: $lat | Long: $long")
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val hasPermission = hasPermissions(context)

        if(hasPermission){
            getLocation(context)
        }else {
            val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){isGranted ->
                if(isGranted){
                    getLocation(context)
                } else {
                  Toast.makeText(
                      context,
                      "No se puede acceder a la ubicación",
                      Toast.LENGTH_LONG
                  ).show()
                }
            }

            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}