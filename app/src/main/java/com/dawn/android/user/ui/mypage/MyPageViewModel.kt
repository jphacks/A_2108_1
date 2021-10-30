package com.dawn.android.user.ui.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.android.auth.domain.service.AccountService
import com.dawn.android.user.domain.model.Me
import com.dawn.android.user.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyPageViewModel(
    private val accountService: AccountService,
    private val userRepository: UserRepository,
) : ViewModel() {
    val loginStatus get() = accountService.loginStatus

    private val _me = MutableStateFlow<Me?>(null)
    val me: StateFlow<Me?> get() = _me

    fun refreshMe() {
        viewModelScope.launch {
            _me.value = userRepository.getMe()
        }
    }
}
