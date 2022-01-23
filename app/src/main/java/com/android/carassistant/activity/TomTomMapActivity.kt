package com.android.carassistant.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.carassistant.BuildConfig
import com.android.carassistant.R
import com.tomtom.online.sdk.map.*

class TomTomMapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var tomtomMap: TomtomMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tom_tom_map)
        initTomTomMap()

    }

    override fun onMapReady(tomtomMap: TomtomMap) {
        this.tomtomMap = tomtomMap
        this.tomtomMap.let {
            it.isMyLocationEnabled = true
            //it.addOnMapLongClickListener(this)
            it.markerSettings.setMarkersClustering(true)
        }
    }

    private fun initTomTomMap() {
        val mapKeys = mapOf(
            ApiKeyType.MAPS_API_KEY to BuildConfig.MAPS_API_KEY
        )
        val mapProperties = MapProperties.Builder()
            .keys(mapKeys)
            .build()
        /*val mapFragment = MapFragment.newInstance(mapProperties)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.map_fragment, mapFragment)
            .commit()*/

        (supportFragmentManager.findFragmentById(R.id.map_fragment) as MapFragment).also {
            it.getAsyncMap(this)
        }
        //mapFragment.getAsyncMap(this)

    }
}