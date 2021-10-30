package com.dawn.android.auth.infra.impl.domain.service

import com.dawn.android.auth.domain.model.LoginRequest
import com.dawn.android.auth.domain.model.LoginStatus
import com.dawn.android.auth.domain.model.RegistrationResult
import com.dawn.android.auth.domain.model.Token
import com.dawn.android.auth.domain.model.UserRegistration
import com.dawn.android.auth.domain.service.AccountService
import com.dawn.android.auth.infra.api.AuthApi
import com.dawn.android.auth.infra.converter.AuthJsonConverter
import com.dawn.android.auth.infra.preferences.TokenPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AccountServiceImpl(
    private val preferences: TokenPreferences,
    private val authApi: AuthApi,

) : AccountService {
    private val _loginStatus = MutableStateFlow(getLoginStatus())
    override val loginStatus: StateFlow<LoginStatus>
        get() = _loginStatus

    override suspend fun login(request: LoginRequest): LoginStatus {
        return try {
            val json = authApi.login(AuthJsonConverter.convertToJson(request))
            val token = AuthJsonConverter.convertToDomainModel(json)
            val result = LoginStatus.LoggedIn(token)
            _loginStatus.value = result
            preferences.putToken(token.value)
            return result
        } catch (e: Exception) {
            _loginStatus.value = LoginStatus.NotLoggedIn
            preferences.delete()
            LoginStatus.NotLoggedIn
        }
    }

    override suspend fun logout() {
        preferences.delete()
        _loginStatus.value = LoginStatus.NotLoggedIn
    }

    override suspend fun register(userRegistration: UserRegistration): RegistrationResult {
        return try {
            val json = authApi.register(AuthJsonConverter.convertToJson(userRegistration))
            val token = AuthJsonConverter.convertToDomainModel(json)
            _loginStatus.value = LoginStatus.LoggedIn(token)
            preferences.putToken(token.value)
            RegistrationResult.Success(token)
        } catch (e: Exception) {
            _loginStatus.value = LoginStatus.NotLoggedIn
            preferences.delete()
            RegistrationResult.Failure(e)
        }
    }

    private fun getLoginStatus(): LoginStatus {
        val token = preferences.getToken() ?: return LoginStatus.NotLoggedIn
        return LoginStatus.LoggedIn(Token(token))
    }
}