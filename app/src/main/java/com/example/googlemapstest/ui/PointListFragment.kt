package com.example.googlemapstest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.googlemapstest.R
import com.example.googlemapstest.adapters.ListOfPointAdapter
import com.example.googlemapstest.databinding.FragmentPointListBinding
import com.example.googlemapstest.viewmodel.LocationViewModel


class PointListFragment : Fragment() {
    private lateinit var binding: FragmentPointListBinding
    private val viewModel: LocationViewModel by sharedViewModel()
    private lateinit var pointsRecyclerView: RecyclerView
    private lateinit var pointsAdapter: ListOfPointAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPointListBinding.inflate(inflater)
        pointsRecyclerView = binding.pointsRv
        pointsAdapter = ListOfPointAdapter(requireContext())
        pointsRecyclerView.adapter = pointsAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.apply {
            getListOfLocation()
            locations.observe(viewLifecycleOwner) { points ->
                if (points != null) {
                    pointsAdapter.updatePoints(points)
                }
            }
        }
    }

    companion object {

        fun newInstance() = PointListFragment()
    }
}