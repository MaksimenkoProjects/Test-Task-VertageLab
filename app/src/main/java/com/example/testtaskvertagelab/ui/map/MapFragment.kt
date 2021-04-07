package com.example.testtaskvertagelab.ui.map

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskvertagelab.MainActivity
import com.example.testtaskvertagelab.R
import com.example.testtaskvertagelab.databinding.FragmentMapBinding
import com.example.testtaskvertagelab.models.Markers
import com.example.testtaskvertagelab.ui.ViewModelFactory
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MapFragment : DaggerFragment(), OnMapReadyCallback{


    @Inject
    lateinit var mainActivity: MainActivity

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: MapViewModel

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    lateinit var mapView: MapView
    lateinit var mMap: GoogleMap

    val markersNameList = arrayListOf<String>()
    lateinit var adapter: ArrayAdapter<String>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        androidInjector().inject(this)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)
        viewModel = ViewModelProvider(this, factory).get(MapViewModel::class.java)
        binding.viewModel = viewModel
        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        mapView.onStart()
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        binding.markersListView.setOnItemClickListener { parent, view, position, id ->
            val latLng = viewModel.markerList.value?.places?.get(position)?.lat?.let {
                viewModel.markerList.value?.places?.get(position)?.lng?.let { it1 ->
                    LatLng(
                        it,
                        it1
                    )
                }
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))

        }
    }


    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        viewModel.markerList.observeForever {
            it.places?.forEach {
                mMap.addMarker(MarkerOptions().position(LatLng(it.lat, it.lng)).title(it.name))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(it.lat, it.lng)))
                markersNameList.add(it.name)
            }
            binding.markersListView.adapter = context?.let { it1 -> ArrayAdapter(it1, android.R.layout.simple_list_item_1, markersNameList) }
        }
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setMinZoomPreference(14.5f)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.markersListView.setOnItemClickListener(null)
        _binding = null
    }

}