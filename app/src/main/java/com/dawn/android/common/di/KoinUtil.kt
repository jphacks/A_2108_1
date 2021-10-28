package com.dawn.android.common.di

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

inline fun <reified VM : ViewModel> NavController.routeViewModel(
    route: String? = null,
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null,
): VM {
    val owner = if (route != null)
        getBackStackEntry(route)
    else
        currentBackStackEntry!!

    return owner.getViewModel(
        qualifier,
        parameters,
    )
}
