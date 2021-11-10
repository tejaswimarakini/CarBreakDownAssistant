package com.android.carassistant.viewmodel

import androidx.lifecycle.ViewModel
import com.android.carassistant.activity.HomeMenuData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {


    fun constructMenuList(): ArrayList<HomeMenuData> {
        val homeMenuList = ArrayList<HomeMenuData>()
        homeMenuList.add(HomeMenuData("Fuel"))
        homeMenuList.add(HomeMenuData("Hospital"))
        homeMenuList.add(HomeMenuData("Restaurants"))
        homeMenuList.add(HomeMenuData("Emergency"))

        return homeMenuList
    }

}