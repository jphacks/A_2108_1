package com.dawn.android.auth.infra.impl.domain.service

import com.dawn.android.auth.domain.model.RegistrationResult
import com.dawn.android.auth.domain.model.UserRegistration
import com.dawn.android.auth.domain.service.SignUpService
import com.dawn.android.auth.infra.api.AuthApi
import com.dawn.android.auth.infra.converter.AuthJsonConverter

class SignUpServiceImpl(
    private val authApi: AuthApi,
) : SignUpService {
    override suspend fun execute(userRegistration: UserRegistration): RegistrationResult {
        return try {
            val json = authApi.register(AuthJsonConverter.convertToJson(userRegistration))
            val token = AuthJsonConverter.convertToDomainModel(json)
            RegistrationResult.Success(token)
        } catch (e: Exception) {
            RegistrationResult.Failure(e)
        }
    }
}