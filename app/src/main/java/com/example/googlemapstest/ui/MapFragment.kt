package com.example.googlemapstest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.domain.model.LocationModel
import com.example.googlemapstest.DialogMenuFragment
import com.example.googlemapstest.R
import com.example.googlemapstest.databinding.FragmentMapBinding
import com.example.googlemapstest.viewmodel.LocationViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var binding: FragmentMapBinding
    private lateinit var googleMap: GoogleMap
    private val viewModel: LocationViewModel by sharedViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater)

        requireActivity().addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.bar_menu, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return when (menuItem.itemId) {
                        R.id.save_location -> {
                            this@MapFragment.onResume()
                            val location = getDefaultCoordinates()
                            DialogMenuFragment.newInstance(
                                location.latitude,
                                location.longitude
                            ).show(childFragmentManager, "Dialog")
                            true
                        }

                        R.id.list_of_points -> {
                            requireActivity().supportFragmentManager
                                .beginTransaction()
                                .addToBackStack("map")
                                .replace(R.id.fragment_container, PointListFragment.newInstance())
                                .commit()
                            true
                        }

                        else -> false
                    }
                }
            }, viewLifecycleOwner, Lifecycle.State.RESUMED
        )
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        updatePoints()
    }

    private fun addMarker(locationModel: LocationModel) {
        val point = LatLng(locationModel.latitude, locationModel.longitude)
        googleMap.addMarker(MarkerOptions().position(point))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MapFragment()
    }

    override fun onMapReady(gMap: GoogleMap) {
        googleMap = gMap
        updatePoints()
        getDefaultCoordinates()
    }

    private fun getDefaultCoordinates(): LatLng {
        return googleMap.cameraPosition.target
    }

    private fun updatePoints() {
        viewModel.apply {
            getListOfLocation()
            locations.observe(viewLifecycleOwner) { points ->
                points?.forEach {
                    addMarker(it)
                }
            }
        }
    }
}