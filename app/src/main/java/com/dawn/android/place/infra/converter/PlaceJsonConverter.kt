package com.dawn.android.place.infra.converter

import com.dawn.android.place.domain.model.Address
import com.dawn.android.place.domain.model.Place
import com.dawn.android.place.infra.api.json.AddressJson
import com.dawn.android.place.infra.api.json.PlaceJson

object PlaceJsonConverter {
    fun convertToJson(model: Place): PlaceJson {
        return PlaceJson(
            id = model.id.value,
            area = model.area,
            prefecture = model.prefecture,
            city = model.city,
            name = model.name,
        )
    }

    fun convertToDomainModel(json: AddressJson): Address {
        return Address(
            plusCode = json.plusCode,
        )
    }
}