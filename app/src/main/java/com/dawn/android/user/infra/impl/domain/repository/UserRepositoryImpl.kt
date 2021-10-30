package com.dawn.android.user.infra.impl.domain.repository

import com.dawn.android.auth.domain.model.LoginStatus
import com.dawn.android.auth.domain.service.AccountService
import com.dawn.android.user.domain.model.Me
import com.dawn.android.user.domain.repository.UserRepository
import com.dawn.android.user.infra.api.UserApi
import com.dawn.android.user.infra.converter.UserJsonConverter

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val accountService: AccountService,
) : UserRepository {
    override suspend fun getMe(): Me {
        val state = accountService.loginStatus.value as? LoginStatus.LoggedIn ?: throw IllegalStateException()
        val json = userApi.getMe(state.token.value)
        return UserJsonConverter.convertToMeDomainModel(json)
    }
}
