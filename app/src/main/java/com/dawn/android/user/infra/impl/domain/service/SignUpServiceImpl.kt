package com.dawn.android.user.infra.impl.domain.service

import com.dawn.android.user.domain.model.SignUpResult
import com.dawn.android.user.domain.model.UserRegistration
import com.dawn.android.user.domain.service.SignUpService
import com.dawn.android.user.infra.api.UserApi
import com.dawn.android.user.infra.converter.UserJsonConverter

class SignUpServiceImpl(
    private val userApi: UserApi,
) : SignUpService {
    override suspend fun execute(userRegistration: UserRegistration): SignUpResult {
        return try {
            val json = userApi.register(UserJsonConverter.convertToJson(userRegistration))
            val token = UserJsonConverter.convertToDomainModel(json)
            SignUpResult.Success(token)
        } catch (e: Exception) {
            SignUpResult.Failure(e)
        }
    }
}