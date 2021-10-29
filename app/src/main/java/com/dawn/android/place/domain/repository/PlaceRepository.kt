package com.dawn.android.place.domain.repository

import com.dawn.android.place.domain.model.Area
import com.dawn.android.place.domain.model.City
import com.dawn.android.place.domain.model.Prefecture

interface PlaceRepository {
    suspend fun getAreas(): List<Area>
    suspend fun getPrefectures(areaId: Int): List<Prefecture>
    suspend fun getCities(areaId: Int,prefectureId: Int): List<City>
}