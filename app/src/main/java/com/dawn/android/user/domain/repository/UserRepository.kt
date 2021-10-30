package com.dawn.android.user.domain.repository

import com.dawn.android.user.domain.model.Me

interface UserRepository {
    suspend fun getMe(): Me
}