package com.dawn.android.auth.ui.register.email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.android.auth.domain.model.RegistrationResult
import com.dawn.android.auth.domain.model.UserRegistration
import com.dawn.android.auth.domain.service.AccountService
import com.dawn.android.place.domain.model.Area
import com.dawn.android.place.domain.model.City
import com.dawn.android.user.domain.model.Contact
import com.dawn.android.place.domain.model.Prefecture
import com.dawn.android.place.domain.repository.PlaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmailRegistrationViewModel(
    private val accountService: AccountService,
    private val placeRepository: PlaceRepository,
) : ViewModel() {
    private val _currentState = MutableStateFlow<EmailRegistrationState>(EmailRegistrationState.Init)
    val currentState: StateFlow<EmailRegistrationState> get() = _currentState

    private val _areas = MutableStateFlow(listOf<Area>())
    val areas: StateFlow<List<Area>> get() = _areas

    private val _prefectures = MutableStateFlow(listOf<Prefecture>())
    val prefectures: StateFlow<List<Prefecture>> get() = _prefectures

    private val _cities = MutableStateFlow(listOf<City>())
    val cities: StateFlow<List<City>> get() = _cities

    private val _loading = MutableStateFlow(false)
    val loading get() = _loading

    private val _finish = MutableStateFlow(false)
    val finish get() = _finish

    fun accountInfo(
        email: String,
        password: String,
        nickname: String,
        userId: String,
    ) {
        _currentState.value = EmailRegistrationState.NicknameUserId(
            email,
            password,
            nickname,
            userId,
        )
        viewModelScope.launch {
            if (_areas.value.isEmpty()) {
                _areas.value = placeRepository.getAreas()
            }
        }
    }

//    fun emailPassword(
//        email: String,
//        password: String,
//    ) {
//        viewModelScope.launch {
//            when (val state = currentState.value) {
//                EmailRegistrationState.Init, is EmailRegistrationState.EmailPassword -> {
//                    _currentState.value = EmailRegistrationState.EmailPassword(
//                        email,
//                        password,
//                    )
//                }
//                is EmailRegistrationState.NicknameUserId -> {
//                    _currentState.value = state.copy(
//                        email = email,
//                        password = password,
//                    )
//                }
//                is EmailRegistrationState.AddressArea -> {
//                    _currentState.value = state.copy(
//                        email = email,
//                        password = password,
//                    )
//                }
//                is EmailRegistrationState.AddressPrefecture -> {
//                    _currentState.value = state.copy(
//                        email = email,
//                        password = password,
//                    )
//                }
//                is EmailRegistrationState.AddressPlace -> {
//                    _currentState.value = state.copy(
//                        email = email,
//                        password = password,
//                    )
//                }
//                is EmailRegistrationState.Biography -> {
//                    _currentState.value = state.copy(
//                        email = email,
//                        password = password,
//                    )
//                }
//                is EmailRegistrationState.Contacts -> {
//                    _currentState.value = state.copy(
//                        email = email,
//                        password = password,
//                    )
//                }
//            }
//        }
//    }
//
//    fun nicknameUserId(
//        nickname: String,
//        userId: String,
//    ) {
//        viewModelScope.launch {
//            when (val state = currentState.value) {
//                is EmailRegistrationState.EmailPassword -> {
//                    _currentState.value = state.next(nickname, userId)
//                }
//                is EmailRegistrationState.NicknameUserId -> {
//                    _currentState.value = state.copy(
//                        nickname = nickname,
//                        userId = userId,
//                    )
//                }
//                is EmailRegistrationState.AddressArea -> {
//                    _currentState.value = state.copy(
//                        nickname = nickname,
//                        userId = userId,
//                    )
//                }
//                is EmailRegistrationState.AddressPrefecture -> {
//                    _currentState.value = state.copy(
//                        nickname = nickname,
//                        userId = userId,
//                    )
//                }
//                is EmailRegistrationState.AddressPlace -> {
//                    _currentState.value = state.copy(
//                        nickname = nickname,
//                        userId = userId,
//                    )
//                }
//                is EmailRegistrationState.Biography -> {
//                    _currentState.value = state.copy(
//                        nickname = nickname,
//                        userId = userId,
//                    )
//                }
//                is EmailRegistrationState.Contacts -> {
//                    _currentState.value = state.copy(
//                        nickname = nickname,
//                        userId = userId,
//                    )
//                }
//                EmailRegistrationState.Init -> {
//                    // invalid
//                }
//            }
//        }
//    }
//
    fun area(area: Area) {
        viewModelScope.launch {
            _prefectures.value = placeRepository.getPrefectures(area.id)
        }
        viewModelScope.launch {
            when (val state = currentState.value) {
                is EmailRegistrationState.NicknameUserId -> {
                    _currentState.value = state.next(area)
                }
                is EmailRegistrationState.AddressArea -> {
                    _currentState.value = state.copy(
                        area = area,
                    )
                }
                is EmailRegistrationState.AddressPrefecture -> {
                    _currentState.value = state.copy(
                        area = area,
                    )
                }
                is EmailRegistrationState.AddressPlace -> {
                    _currentState.value = state.copy(
                        area = area,
                        place = state.place.copy(
                            area = area.id,
                        )
                    )
                }
                is EmailRegistrationState.Biography -> {
                    _currentState.value = state.copy(
                        area = area,
                        place = state.place.copy(
                            area = area.id,
                        )
                    )
                }
                is EmailRegistrationState.Contacts -> {
                    _currentState.value = state.copy(
                        area = area,
                    )
                }
                else -> {
                    // invalid
                }
            }
        }
    }

    fun prefecture(area: Area, prefecture: Prefecture) {
        viewModelScope.launch {
            _cities.value = placeRepository.getCities(area.id, prefecture.id)
        }
        viewModelScope.launch {
            when (val state = currentState.value) {
                is EmailRegistrationState.AddressArea -> {
                    _currentState.value = state.next(prefecture)
                }
                is EmailRegistrationState.AddressPrefecture -> {
                    _currentState.value = state.copy(
                        prefecture = prefecture,
                    )
                }
                is EmailRegistrationState.AddressPlace -> {
                    _currentState.value = state.copy(
                        prefecture = prefecture,
                        place = state.place.copy(
                            prefecture = prefecture.id
                        )
                    )
                }
                is EmailRegistrationState.Biography -> {
                    _currentState.value = state.copy(
                        prefecture = prefecture,
                        place = state.place.copy(
                            prefecture = prefecture.id
                        )
                    )
                }
                is EmailRegistrationState.Contacts -> {
                    _currentState.value = state.copy(
                        prefecture = prefecture,
                        place = state.place.copy(
                            prefecture = prefecture.id
                        )
                    )
                }
            }
        }
    }

    fun city(city: City) {
        viewModelScope.launch {
            when (val state = currentState.value) {
                is EmailRegistrationState.AddressPrefecture -> {
                    _currentState.value = state.next(city)
                }
                is EmailRegistrationState.AddressPlace -> {
                    _currentState.value = state.copy(
                        place = state.place.copy(
                            city = city.id,
                            name = state.area.name + state.prefecture.name + city.name,
                        )
                    )
                }
                is EmailRegistrationState.Biography -> {
                    _currentState.value = state.copy(
                        place = state.place.copy(
                            city = city.id,
                            name = state.area.name + state.prefecture.name + city.name,
                        )
                    )
                }
                is EmailRegistrationState.Contacts -> {
                    _currentState.value = state.copy(
                        place = state.place.copy(
                            city = city.id,
                            name = state.area.name + state.prefecture.name + city.name,
                        )
                    )
                }
            }
        }
    }

    fun biography(biography: String) {
        viewModelScope.launch {
            when (val state = currentState.value) {
                is EmailRegistrationState.AddressPlace -> {
                    _currentState.value = state.next(biography)
                }
                is EmailRegistrationState.Biography -> {
                    _currentState.value = state.copy(
                        biography = biography,
                    )
                }
                is EmailRegistrationState.Contacts -> {
                    _currentState.value = state.copy(
                        biography = biography,
                    )
                }
            }
        }
    }

    fun contact(contact: Contact) {
        viewModelScope.launch {
            when (val state = currentState.value) {
                is EmailRegistrationState.Biography -> {
                    val request = state.next(contact).toUserRegistration()
                    register(request)
                }
                is EmailRegistrationState.Contacts -> {
                    val next = state.copy(
                        contact = contact,
                    )
                    val request = next.toUserRegistration()
                    register(request)
                }
            }
        }
    }

    private suspend fun register(userRegistration: UserRegistration) {
        _loading.value = true
        when (accountService.register(userRegistration)) {
            is RegistrationResult.Success -> {
                _loading.value = false
                _finish.value = true
            }
            is RegistrationResult.Failure -> {
                _loading.value = false
                _finish.value = true
            }
        }
    }
}
