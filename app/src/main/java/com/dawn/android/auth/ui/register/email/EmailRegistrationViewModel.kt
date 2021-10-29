package com.dawn.android.auth.ui.register.email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.android.auth.domain.service.AccountService
import com.dawn.android.user.domain.model.Area
import com.dawn.android.user.domain.model.Prefecture
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmailRegistrationViewModel(
    private val accountService: AccountService,
) : ViewModel() {
    private val _currentState = MutableStateFlow<EmailRegistrationState>(EmailRegistrationState.Init)
    val currentState: StateFlow<EmailRegistrationState> get() = _currentState



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
//    fun area(area: Area) {
//        viewModelScope.launch {
//            when (val state = currentState.value) {
//                is EmailRegistrationState.NicknameUserId -> {
//                    _currentState.value = state.next(area)
//                }
//                is EmailRegistrationState.AddressArea -> {
//                    _currentState.value = state.copy(
//                        area = area,
//                    )
//                }
//                is EmailRegistrationState.AddressPrefecture -> {
//                    _currentState.value = state.copy(
//                        area = area,
//                    )
//                }
//                is EmailRegistrationState.AddressPlace -> {
//                    _currentState.value = state.copy(
//                        area = area,
//                        place = state.place.copy(
//                            area = area.id,
//                        )
//                    )
//                }
//                is EmailRegistrationState.Biography -> {
//                    _currentState.value = state.copy(
//                        area = area,
//                        place = state.place.copy(
//                            area = area.id,
//                        )
//                    )
//                }
//                is EmailRegistrationState.Contacts -> {
//                    _currentState.value = state.copy(
//                        area = area,
//                    )
//                }
//                else -> {
//                    // invalid
//                }
//            }
//        }
//    }
//
//    fun prefecture(prefecture: Prefecture) {
//        viewModelScope.launch {
//            when (val state = currentState.value) {
//                is EmailRegistrationState.AddressArea -> {
//                    _currentState.value = state.next(prefecture)
//                }
//                is EmailRegistrationState.AddressPrefecture -> {
//                    _currentState.value = state.copy(
//                        prefecture = prefecture,
//                    )
//                }
//                is EmailRegistrationState.AddressPlace -> {
//                    _currentState.value = state.copy(
//                        prefecture = prefecture,
//                        place = state.place.copy(
//                            prefecture = prefecture.id
//                        )
//                    )
//                }
//            }
//        }
//    }
}
