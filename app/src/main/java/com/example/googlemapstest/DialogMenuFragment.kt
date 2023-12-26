package com.example.googlemapstest

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.domain.model.LocationModel
import com.example.googlemapstest.databinding.FragmentDialogBinding
import com.example.googlemapstest.viewmodel.LocationViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DialogMenuFragment : DialogFragment() {

    private val viewModel: LocationViewModel by sharedViewModel()
    private lateinit var binding: FragmentDialogBinding
    private var latitude: Double? = null
    private var longitude: Double? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentDialogBinding.inflate(layoutInflater)
        arguments?.let {
            latitude = it.getDouble(ARG_PARAM1)
            longitude = it.getDouble(ARG_PARAM2)
        }
        binding.apply {
            editLatitude.setText(getString(R.string.DEGREE_LABEL, latitude?.toString()?.take(7)))
            editLongitude.setText(getString(R.string.DEGREE_LABEL, longitude?.toString()?.take(7)))
            btSaveLocation.setOnClickListener {
//                Log.d("LOCATION", "Lat is $latitude, long is $longitude")
                if (latitude != null && longitude != null) {
                    viewModel.addLocation(
                        LocationModel(
                            0, latitude!!, longitude!!, null
                        )
                    )
                }
                dismiss()
            }
        }

            val dialog = AlertDialog.Builder(requireContext())
                .setView(binding.root)
                .create()
            return dialog
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        }

        companion object {
            const val TAG = "Dialog"

            @JvmStatic
            fun newInstance(param1: Double, param2: Double) =
                DialogMenuFragment().apply {
                    arguments = Bundle().apply {
                        putDouble(ARG_PARAM1, param1)
                        putDouble(ARG_PARAM2, param2)
                    }
                }
        }
    }