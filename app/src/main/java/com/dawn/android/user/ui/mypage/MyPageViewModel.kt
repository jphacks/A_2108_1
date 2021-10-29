package com.dawn.android.user.ui.mypage

import androidx.lifecycle.ViewModel
import com.dawn.android.auth.domain.service.AccountService

class MyPageViewModel(
    private val accountService: AccountService,
) : ViewModel() {
    val loginStatus get() = accountService.loginStatus
}
