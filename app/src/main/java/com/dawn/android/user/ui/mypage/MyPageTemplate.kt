package com.dawn.android.user.ui.mypage

import androidx.compose.runtime.Composable
import com.dawn.android.user.domain.model.Me

@Composable
fun MyPageTemplate(
    me: Me,
) {
    UserTemplate(user = me)
}
