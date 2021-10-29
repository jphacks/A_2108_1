package com.dawn.android.place.infra.impl.domain.repository

import com.dawn.android.place.domain.model.Area
import com.dawn.android.place.domain.model.City
import com.dawn.android.place.domain.model.Prefecture
import com.dawn.android.place.domain.repository.PlaceRepository
import com.dawn.android.place.infra.api.PlaceApi

class PlaceRepositoryImpl(
    private val placeApi: PlaceApi,
) : PlaceRepository {
    override suspend fun getAreas(): List<Area> {
        return placeApi
            .getAreas()
            .map {
                Area(
                    id = it.area,
                    name = it.name,
                )
            }
    }

    override suspend fun getPrefectures(areaId: Int): List<Prefecture> {
        return placeApi
            .getPrefectures(areaId)
            .map {
                Prefecture(
                    id = it.prefecture,
                    name = it.name,
                )
            }
    }

    override suspend fun getCities(areaId: Int, prefectureId: Int): List<City> {
        return placeApi
            .getCities(areaId, prefectureId)
            .map {
                City(
                    id = it.city,
                    name = it.name,
                )
            }
    }
}
