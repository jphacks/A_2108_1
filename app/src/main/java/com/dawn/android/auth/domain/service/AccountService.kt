package com.dawn.android.auth.domain.service

import com.dawn.android.auth.domain.model.LoginRequest
import com.dawn.android.auth.domain.model.LoginStatus
import com.dawn.android.auth.domain.model.RegistrationResult
import com.dawn.android.auth.domain.model.UserRegistration
import kotlinx.coroutines.flow.StateFlow

interface AccountService {
    val loginStatus: StateFlow<LoginStatus>
    suspend fun login(request: LoginRequest): LoginStatus
    suspend fun logout()
    suspend fun register(userRegistration: UserRegistration): RegistrationResult
}