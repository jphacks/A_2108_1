package com.dawn.android.plan.ui

sealed class PlanNavItems(val route: String) {
    object Home : PlanNavItems("Home")
    object PlanDetail : PlanNavItems("PlanDetail") {
        val planIdArg = "planId"
    }
}
