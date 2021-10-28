package com.dawn.android.auth.domain.service

import com.dawn.android.auth.domain.model.UserRegistration
import com.dawn.android.auth.domain.model.RegistrationResult

interface SignUpService {
    suspend fun execute(userRegistration: UserRegistration): RegistrationResult
}
