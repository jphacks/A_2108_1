package com.dawn.android.user.domain.service

import com.dawn.android.user.domain.model.Me
import com.dawn.android.user.domain.model.SignUpResult

interface SignUpService {
    suspend fun execute(me: Me): SignUpResult
}
