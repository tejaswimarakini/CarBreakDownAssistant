package com.android.carassistant.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(): ViewModel() {



    /*var locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult : LocationResult?) {
            locationResult ?: return // if null return
            for (location in locationResult.locations) {
                // Update the map to zoom to the current location

            }

        }
    }*/

}