package com.dawn.android.user.domain.service

import com.dawn.android.user.domain.model.UserRegistration
import com.dawn.android.user.domain.model.SignUpResult

interface SignUpService {
    suspend fun execute(userRegistration: UserRegistration): SignUpResult
}
