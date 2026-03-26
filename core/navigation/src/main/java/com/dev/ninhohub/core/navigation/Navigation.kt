package com.dev.ninhohub.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions

/**
 * Extensões de utilitários de navegação seguindo o padrão Now in Android.
 */
fun NavController.navigateToRoute(route: Any, navOptions: NavOptions? = null) {
    this.navigate(route, navOptions)
}

fun NavController.navigateToRoute(route: Any, builder: NavOptionsBuilder.() -> Unit) {
    this.navigate(route, navOptions(builder))
}
