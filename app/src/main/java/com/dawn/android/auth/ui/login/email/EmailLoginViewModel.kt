package com.dawn.android.auth.ui.login.email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.android.auth.domain.model.LoginRequest
import com.dawn.android.auth.domain.model.LoginStatus
import com.dawn.android.auth.domain.service.AccountService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmailLoginViewModel(
    private val accountService: AccountService,
) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _finish = MutableStateFlow(false)
    val finish: StateFlow<Boolean> get() = _finish

    private val _message = MutableStateFlow<String?>(null)
    val message: StateFlow<String?> get() = _message

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loading.value = true
            val request = LoginRequest(email, password)
            when (accountService.login(request)) {
                is LoginStatus.LoggedIn -> {
                    _loading.value = false
                    _finish.value = true
                }
                LoginStatus.NotLoggedIn -> {
                    _loading.value = false
                    _message.value = "ログインに失敗しました"
                    _message.value = null
                }
            }
        }
    }
}